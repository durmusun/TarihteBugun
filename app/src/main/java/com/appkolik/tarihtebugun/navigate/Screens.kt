package com.appkolik.tarihtebugun.navigate

sealed class Screens(val route : String){
    object ListScreen : Screens("list_screen/{listType}"){
        fun withType(listType : String) : String {
            return "list_screen/$listType"
        }
    }
    object DetailScreen : Screens("detail_screen/{history}"){
        fun withHistoryDetail(historyJson : String) : String{
            return "detail_screen/$historyJson"
        }
    }
}



