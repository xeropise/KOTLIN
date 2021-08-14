package highorderfunction

import java.util.concurrent.locks.Lock

// 람다를 활용한 코드의 성능은 어떨까? => 람다를 사용하는 구현은 똑같은 작업을 수행하는 일반 함수를 사용한 구현보다 덜 효율적이다.
// inline 변경자를 어떤 함수에 붙이면 컴파일러는 그 함수를 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔치기 해준다.
// 반복되는 코드를 별도의 라이브러리 함수로 빼내어, 자바의 일반 명령문만큼 효율적인 코드를 생성하게 하낟.

// 인라인 함수를 정의해보자.
// synchronized 함수를 inline으로 선언했으므로 syncrhonized 를 호출하는 코드는 모두 자바의 synchronized 문과 같아진다고 한다.
inline fun <T> synchronized(lock: Lock, action: () -> T ) : T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

// inline 함수 솔직히 이해 잘 못하겠다... 나중에 실력이 오르면 다시 정의하자.

fun main() {
    /*
        val l = Lock()
        synchronized(l) {

        }
     */
}