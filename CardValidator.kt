import java.time.YearMonth
class Card{
    fun cardChecker(cardNumber: String):Boolean{
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
            return true
        }
        else{
            println("Card Number is Numerically Invalid")
            return false
        }
    }

    fun cvvChecker(cvv:String,network:String): Boolean{
        if (cvv.any{it.isLetter()}){
            return false
        }
        val cleanedNetwork = network.replace(" ","").lowercase()
        val fourList: List<String> = listOf("americanexpress")
        val threeList: List<String> = listOf("visa","mastercard","discover","dinersclub","jcb")
        if (cvv.length == 4 && cleanedNetwork in fourList){
            return true
        }
        else if(cvv.length == 3 &&network in threeList){
            return true
        }
        return false
    }
    fun dateChecker(date:String): Boolean{
        val lst: MutableList<String> = date.split("/").toMutableList()
        if (lst[0].length==1){
            lst[0] = "0"+lst[0]
        }
        if (lst[1].length==1){
            lst[1] = "0"+lst[1]
        }
        val currentDate = YearMonth.now()
        val currentMonth = currentDate.month.toString()
        val currentYear = currentDate.year.toString()

        if (currentYear.toInt()<lst[1].toInt()){
            return true
        }
        else if(currentYear.toInt()==lst[1].toInt()){
            if(currentMonth.toInt()<lst[0].toInt()){
                return true
            }
            else if (currentMonth.toInt()==lst[0].toInt()){
                return true
            }
        }
        return false
    }
}


fun main(){
    print("Enter your card number: ")
    val cardNum: String = readln()
    if (cardNum.length>19){
        println("Sorry but your card Num cant be greater than 16\n\n")
    }
    else{
        val card = Card()
        val cardResponse: Boolean = card.cardChecker(cardNum)
        if (cardResponse){
            print("Enter your cvv for the given card: ")
            val cvv: String = readln()
            print("Enter your network: ")
            val network: String = readln()
            val response: Boolean = card.cvvChecker(cvv,network)
            if (response){
                println("The CVV Provided is Valid")
                print("Enter the exp date [MM/YY]: ")
                
            }
            else{
                println("The CVV Provided is Invalid")
            }
        }
    }
}