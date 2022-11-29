package com.example.droi_mvvm.model

class DC_JOB {
    data class ResRecruit(
        var recruit_items: ArrayList<recruit_items> = ArrayList(),
    )
    data class ResCell(
        var cell_items: ArrayList<cell_items> = ArrayList(),
    )
    data class recruit_items(
        var id: Int = 0,
        var title: String = "",
        var reward: Int = 0,
        var appeal: String = "",
        var image_url: String = "",
        var company: company = company(),
    )
    data class company(
        var name: String = "",
        var logo_path: String = "",
        var image_url: String = "",
        var ratings: ArrayList<rating> = ArrayList(),
    )
    data class rating(
        var type: String = "",
        var rating: Int = 0,
    )


    data class cell_items(
        var cell_type: String = "",
        var logo_path: String = "",
        var name: String = "",
        var industry_name: String = "",
        var rate_total_avg: Int = 0,
        var review_summary: String = "",
        var interview_question: String = "",
        var salary_avg: Int = 0,
        var update_date: String = "",
        var count: Int = 0,
        var section_title: String = "",
        var recommend_recruit: ArrayList<recruit_items> = ArrayList(),
    )



}


