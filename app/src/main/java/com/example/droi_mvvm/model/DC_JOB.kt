package com.example.droi_mvvm.model

class DC_JOB {
    data class ResRecruit(
        var recruit_items: ArrayList<Recruit_items> = ArrayList(),
    )
    data class ResCell(
        var cell_items: ArrayList<Cell_items> = ArrayList(),
    )
    data class Recruit_items(
        var id: Int = 0,
        var title: String = "",
        var reward: Int = 0,
        var appeal: String = "",
        var image_url: String = "",
        var company: Company = Company(),
    )
    data class Company(
        var name: String = "",
        var logo_path: String = "",
        var image_url: String = "",
        var ratings: ArrayList<Rating> = ArrayList(),
    )
    data class Rating(
        var type: String = "",
        var rating: Float = 0f,
    )


    data class Cell_items(
        var cell_type: String = "",
        var logo_path: String = "",
        var name: String = "",
        var industry_name: String = "",
        var rate_total_avg: Float = 0f,
        var review_summary: String = "",
        var interview_question: String = "",
        var salary_avg: Int = 0,
        var update_date: String = "",
        var count: Int = 0,
        var section_title: String = "",
        var recommend_recruit: ArrayList<Recruit_items> = ArrayList(),
    )



}


