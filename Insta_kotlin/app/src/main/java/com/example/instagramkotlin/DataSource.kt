package com.example.instagramkotlin

class DataSource {
    companion object {

        fun createDataSet(): ArrayList<ListItem> {
            val list = ArrayList<ListItem>()
            list.add(
                ListItem(
                    "Mitch!",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png"
                )
            )
            list.add(
                ListItem(
                    "WillSmith",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png"
                )
            )

            list.add(
                ListItem(
                    "WillSmith",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png"
                )
            )
            list.add(
                ListItem(
                    "Sam",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png"
                )
            )
            list.add(
                ListItem(
                    "Rayman",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png"

                )
            )
            list.add(
                ListItem(
                    "Rayman",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/work_life_balance.png"
                )
            )
            list.add(
                ListItem(
                    "Rayman",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/fullsnack_developer.png"
                )
            )
            list.add(
                ListItem(
                    "Rayman",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/javascript_expert_wes_bos.png"
                )
            )
            list.add(
                ListItem(
                    "Rayman",
                    54640,
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/senior_android_engineer_kaushik_gopal.png"
                )
            )
            return list
        }
    }

}