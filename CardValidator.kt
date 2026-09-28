data class Card(val userName:String?, val cardNumber: String,val cvv:String,val expDate:String){

    val userNameClass = userName
    val cardNumberClass = cardNumber
    val cvvClass = cvv
    val expDateClass = expDate

    fun validateUser(): Int{
        return if (!userNameClass.isNullOrEmpty()){
            println("User Validated!")
            0
        } else{

            1
        }
    }

    fun validateNumber(): Int{
        return if (cardNumberClass.replace("-","").length in 10..19){
            println("Number Validated")
            0
        }
        else{

            1
        }
    }

    fun validateCvv():Int {
        return if (cvvClass.length in 3..4){
            println("CVV Validated!")
            0
        }
        else{
            1
        }
    }

    fun validateDate():Int{
        return if ("/" in expDateClass && expDateClass.length in 3..5){
            println("Date Validated1!")
            0
        }
        else{
            1
        }
    }

}

fun main(){
    var response: Int
    var card: Card?
    while(true){
        println("====================================================")
        println("1. Add a card")
        println("2. Validate the card")
        println("3. Display the card")
        println("4. Exit")
        println("====================================================")
        response = readln().toInt()
        if (response in 1..4){
            if (response == 1){
                card = inputCard()
                println(card)
            }
        }
    }
}

fun inputCard():Card{
    print("Enter your username: ")
    val username: String = readln()
    print("Enter your card number: ")
    val cardNum:String = readln()
    print("Enter your cvv code:")
    val cvv: String = readln()
    print("Enter your exp date: ")
    val exp:String = readln()
    return Card(username,cardNum,cvv,exp)
}