package typeSystem.`null`

// 코틀린에서 자바 메소드를 오버라이드할 때, 그 메소드의 파라미터와 반환 타입을
// 널이 될 수 있는 타입으로 선언할지, 널이 될 수 없는 타입으로 선언할지 결정해야 한다.

// 자바 인터페이스를 여러 다른 널 가능성으로 구현하기
/*
interface StringProcessor {
    void process(String value);
}

class StringPrinter : StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null) {
            println(value
        }
    }

 */