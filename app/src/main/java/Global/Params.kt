package Global

import java.text.SimpleDateFormat
import java.util.Date

object Params {
    fun getCurrentDate():String{
        val curDate=Date()
        val dateFormat=SimpleDateFormat("DD/MM/YYYY")
        val formattedDate=dateFormat.format(curDate)
        return formattedDate
    }
}