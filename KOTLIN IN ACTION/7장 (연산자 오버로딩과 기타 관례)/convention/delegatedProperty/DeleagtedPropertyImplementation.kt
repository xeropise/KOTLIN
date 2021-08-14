package convention.delegatedProperty

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 어떤 객체의 프로퍼티가 바뀔 때마다 리스너에게 변경 통지를 보내고 싶다.
// 자바에서는 PropertyChangeSupport 와 PropertyChangeEvent 클래스를 사용해 이런 통지를 처리하는 경우가 자주 있다.

// 코틀린에서 위임 프로퍼티 없이 이런 기능을 구현하고, 나중에 그 코드를 위임 프로퍼티를 사용하게 리팩토링 해 보자.

// PropertyChangeSupport 클래스는 리스너의 목록을 관리하고, PropertyChangeEvent 이벤트가 들어오면 목록의 모든 리스너에게 이벤트를 통지한다.
// 자바 빈 클래스의 필드에 PropertyChangeSupport 인스턴스를 저장하고 프로퍼티 변경 시, 그 인스턴스에게 처리를 위임하는 방식으로 이런 통지 기능을 주로 구현한다.

// 필드를 모든 클래스에 추가하고 싶지는 않으므로 PropertyChangeSupport 인스턴스를 changeSupport 라는 필드에 저장하고,
// 프로퍼티 변경 리스너를 추적해주는 작은 도우미 클래스를 만들어 보자.

// 리스너 지원이 필요한 클래스는 이 도우미 클래스를 확장해서 changeSupport 에 접근할 수 있다.

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// Person 클래스를 작성하고, 나이나 급여가 바뀌면 그 사실을 리스너에게 공지하자.
class _Person (
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
     var age: Int = age
        set(newValue) {
            val oldValue = field        // 뒷받침하는 필드에 접근할 때 field 식별자를 사용한다.
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue) // 프로퍼티 변경을 리스너에게 통지한다.
        }

     var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

// 세터 코드를 보면 중복이 많아보이므로, 프로퍼티의 값을 저장하고 필요에 따라 통지를 보내주는 클래스를 추출해 보자.
class ObservableProperty(
    val propName: String, var propValue: Int,
    val changeSupport: PropertyChangeSupport
) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class _Person2 (
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) {_age.setValue(value)}

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) {_salary.setValue(value)}
}

// 아직도 각각의 프로퍼티마다 ObservableProperty 를 만들고 게터와 세터에서 ObservableProperty에 작업을 위임하는 준비 코드가 상당 부분 필요하다.
// 코틀린의 위임 프로퍼티 기능을 활용하면 이런 준비 코드를 없앨 수 있다.

// 위임 프로퍼티를 사용하기 전에 ObservableProperty에 있는 두 메소드의 시그니처를 코틀린의 관례에 맞게 수정해야 한다.
class ObservableProperty2(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Person3, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person3, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

}

// 위임 프로퍼티를 통해 프로퍼티 변경 통지 받기
class Person3(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    var age: Int by ObservableProperty2(age, changeSupport)
    var salary: Int by ObservableProperty2(salary, changeSupport)
}

// 코틀린 표준 라이브러리를 사용해 관찰 가능한 프로퍼티 로직을 대신 사용할 수 있다.
// 다만 이 표준 라이브러리 클래스는 PropertyChangeSupport 와는 연결되어 있지 않다.
// 프로퍼티 값의 변경을 통지할 때 PropertyChangeSupport 를 사용하는 방법의 람다를 넘겨야 한다.

// Delegates.observable 을 사용해 프로퍼티 변경 통지 구현하기
class Person4(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
    // 우항이 반드시 새 인스턴스를 만들 필요는 없다.
    // 우항에 있는 식을 계산한 결과인 객체는 컴파일러가 호출할 수 있는 getValue 와 setValue 를 반드시 제공해야 한다.
}

fun main() {
    val p = _Person("Dmitry", 34, 2000)
    p.addPropertyChangeListener { event ->
        println(
            "Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    }

    p.age = 35 // Property age changed from 34 to 35
    p.salary = 2100 // Property salary changed from 2000 to 2100
}

