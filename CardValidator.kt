class Card{

    fun cardChecker(cardNumber: String){
        var rightToLeft = cardNumber.reversed()
        rightToLeft = rightToLeft.replace(" ","")
        var doubleC: Int = 0
        var sumD: Int = 0
        var sumUd: Int = 0
        for (i in 0..<rightToLeft.length){
            if (i%2==0){
                sumUd += rightToLeft[i].digitToInt()
            }
            else{
                doubleC = (rightToLeft[i].digitToInt())*2
                if (doubleC>9){
                    doubleC -= 9
                    sumD += doubleC
                }
                else{
                    sumD += doubleC
                }
                doubleC = 0
            }
        }
        val sum = sumD+sumUd
        if (sum %10 == 0){
            println("Card Number is Numerically Valid")
        }
        else{
            println("Card Number is Numerically Invalid")
        }
    }
}


fun main(){
    print("Enter your card number: ")
    val cardNum: String = readln()
    if (cardNum.length>19){
        println("Sorry but your card Num cant be greater than 16")
    }
    else{
        val card = Card()
        card.cardChecker(cardNum)
    }
}