package typeSystem

import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JList

// 널 아님 단언 사용하기
fun ignoreNulls(s: String?) {
    val sNotNull: String = s!! // 예외는 이 지점을 가르킨다
    println(sNotNull.length)
}

// 스윙 액션에서 널 아님 단언 사용하기
class CopyRowAction(val list: JList<String>) : AbstractAction() {
    override fun isEnabled(): Boolean = list.selectedValue != null

    override fun actionPerformed(e: ActionEvent?) {  // actionPerformed는 isEnabled 가 true인 경우 호출
        val value = list.selectedValue!!
        // value를 클립보드로 복사
    }
}

fun main() {
    ignoreNulls(null) // kotlin.KotlinNullPointerException


    // !!는 널에 대해 사용해서 발생하는 예외의 스택 트레이스에서는 몇 번째 줄인지에 대한 정보는 있지만, 어떤식에서 발생했는지에 대한 정보는 없다.
    // person.company!!.address!!.country   [ 이런식으로 코드를 작성하지 마라 ]
}