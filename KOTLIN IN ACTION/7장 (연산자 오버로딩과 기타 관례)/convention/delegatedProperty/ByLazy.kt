package convention.delegatedProperty

// 지연 초기화(lazy initialization)은 객체의 일부분을 초기화하지 않고 남겨뒀다가
// 실제로 그 부분의 값이 필요할 경우, 초기화할 때 흔히 쓰이는 패턴이다.

// 초기화 과정에 자원을 많이 사용하거나 객체를 사용할 때마다 꼭 초기화하지 않아도 되는 프로퍼티에 대해
// 지연 초기화 패턴을 사용할 수 있다.

// 이메일은 데이터베이스에 들어있고 불러올려면 시간이 오래 걸린다.
// 이메일 프로퍼티의 값을 최초로 사용할 때, 단 한 번만 이메일을 데이터베이스에서 가져오고 싶다면?

class Email { /* .. */ }

fun loadEmails(person: Person): List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(/*..*/)
}

// 이메일을 불러오기 전에 null 을 저장하고, 불러온 다음에 이메일 리스트를 저장하는 _emails 프로퍼티를 추가해
// 지연 초기화를 구현하는 클래스를 만들어 보자
class Person(val name: String) {
    private var _emails: List<Email>? = null           // 데이터를 저장하고 emails의 위임 객체 역할을 하는 _emails 프로퍼티
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)       // 최초 접근 시 이메일을 가져온다.
            }
            return _emails!!                            // 저장해 둔 데이터가 있으면 그 데이터를 반환한다.
        }
}

// 이러한 기법을 뒷받침하는 프로퍼티(backing property) 기법이라 한다.
// 지연 초기화해야 하는 프로퍼티가 많아지면?
// 스레드 안전하지 않아서 언제내 제대로 작동한다고 말할 수도 없다.

// 위임 프로퍼티를 사용하면 이 코드가 훨씬 간단해진다.
// 위임 프로퍼티는 데이터를 저장할 때 쓰이는 뒷받침하는 프로퍼티와 값이 오직 한 번만 초기화됨을 보장하는 게터 로직을 함께 캡슐화해준다.

// 이러한 역할을 하는 함수가 lazy 이다.
/*
    class Person(val name: String) {
        val emails by lazy { loadEmails(this) } // loadEmails(this) 함수는 값을 초기화할 때 호출할 람다다.
    }
*/

// lazy 함수는 기본적으로 스레드 안전하다.
// 동기화에 사용할 락을 lazy 함수에 전달할 수도 있고,
// 다중 스레드 환경에서 사용하지 않을 프로퍼티를 위해 lazy 함수가 동기화를 하지 못하게 막을 수도 있다.

fun main() {
    val p = Person("Alice")
    p.emails // Load emails for Alice
}