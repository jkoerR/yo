package com.example.droi_mvvm.model

class DC_OP {
    data class summoner(
        var name: String = "",
        var level: String = "",
        var profileImageUrl: String = "",
        var leagues: ArrayList<leagues> = ArrayList(),
    )

    data class leagues(
        var wins: String = "",
        var losses: String = "",
        var tierRank: tierRank = tierRank(),
    )

    data class tierRank(
        var name: String = "",
        var imageUrl: String = "",
    )


//    {"summoner":{"name":"genetory","level":93,"profileImageUrl":"https://opgg-static.akamaized.net/images/profile_icons/profileIcon1625.jpg","profileBorderImageUrl":"https://opgg-static.akamaized.net/images/borders2/challenger.png","url":"https://www.op.gg/summoner/userName=genetory","leagues":[{"hasResults":true,"wins":394,"losses":757,"tierRank":{"name":"솔랭","tier":"Bronze","tierDivision":"Bronze","string":"Bronze (26LP)","shortString":"B1","division":"i","imageUrl":"https://opgg-static.akamaized.net/images/medals/bronze_1.png","lp":26,"tierRankPoint":399}},{"hasResults":true,"wins":967,"losses":198,"tierRank":{"name":"자유 5:5 랭크","tier":"Gold","tierDivision":"Gold","string":"Gold (709LP)","shortString":"G1","division":"i","imageUrl":"https://opgg-static.akamaized.net/images/medals/gold_1.png","lp":709,"tierRankPoint":319}}],"previousTiers":[{"name":"솔랭","tier":"Platinum","tierDivision":"Platinum","string":"Platinum (983LP)","shortString":"P1","division":"i","imageUrl":"https://opgg-static.akamaized.net/images/medals/platinum_1.png","lp":983,"tierRankPoint":477,"season":9}],"ladderRank":{"rank":484245,"rankPercentOfTop":8},"profileBackgroundImageUrl":"http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Taliyah_0.jpg"}}


    data class games(
        var champion: champion = champion(),
        var spells: ArrayList<spells> = ArrayList(),
        var items: ArrayList<items> = ArrayList(),
        var createDate: Int = 0,
        var gameType: String = "",
        var gameLength: Int = 0,
        var isWin: Boolean = false,
        var stats: stats = stats(),
        var champions: ArrayList<champions> = ArrayList(),
    )

    data class champion(
        var imageUrl: String = "",
        var level: String = "",
    )

    data class spells(
        var imageUrl: String = "",
    )

    data class items(
        var imageUrl: String = "",
    )
    data class stats(
        var general: general = general(),
    )
    data class general(
        var kill: Int = 0,
        var death: Int = 0,
        var assist: Int = 0,
        var opScoreBadge: String = "",
        var contributionForKillRate: String = "",
    )
    data class champions(
        var id: Int = 0,
        var key: String = "",
        var name: String = "",
        var imageUrl: String = "",
        var games: Int = 0,
        var kills: Int = 0,
        var deaths: Int = 0,
        var assists: Int = 0,
        var wins: Int = 0,
        var losses: Int = 0,
    )

//    {"games":[{"mmr":413,"champion":{"imageUrl":"https://opgg-static.akamaized.net/images/lol/champion/Lucian.png","level":9},"spells":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerTeleport.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerFlash.png"}],"items":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3113.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3198.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3020.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3020.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3364.png"}],"needRenew":false,"gameId":"128446428","createDate":1668778967,"gameLength":1882,"gameType":"자유 5:5 랭크","summonerId":"60235256","summonerName":"genetory","tierRankShort":"C1","stats":{"general":{"kill":9,"death":2,"assist":4,"kdaString":"6.50:1","cs":159,"csPerMin":7.5,"contributionForKillRate":"14%","goldEarned":3535,"totalDamageDealtToChampions":5870,"largestMultiKillString":"","opScoreBadge":"ACE"},"ward":{"sightWardsBought":0,"visionWardsBought":2}},"mapInfo":null,"peak":["https://opgg-static.akamaized.net/images/lol/perk/8229.png","https://opgg-static.akamaized.net/images/lol/perkStyle/8300.png"],"isWin":false},{"mmr":2569,"champion":{"imageUrl":"https://opgg-static.akamaized.net/images/lol/champion/Malzahar.png","level":6},"spells":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerTeleport.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerFlash.png"}],"items":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3113.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/1026.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3364.png"}],"needRenew":false,"gameId":"471750846","createDate":1668776830,"gameLength":816,"gameType":"솔랭","summonerId":"60235256","summonerName":"genetory","tierRankShort":"C1","stats":{"general":{"kill":8,"death":2,"assist":4,"kdaString":"6.00:1","cs":150,"csPerMin":7.5,"contributionForKillRate":"3%","goldEarned":3945,"totalDamageDealtToChampions":1913,"largestMultiKillString":"Double Kill","opScoreBadge":"ACE"},"ward":{"sightWardsBought":0,"visionWardsBought":2}},"mapInfo":null,"peak":["https://opgg-static.akamaized.net/images/lol/perk/8229.png","https://opgg-static.akamaized.net/images/lol/perkStyle/8300.png"],"isWin":false},{"mmr":861,"champion":{"imageUrl":"https://opgg-static.akamaized.net/images/lol/champion/Qiyana.png","level":3},"spells":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerTeleport.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerFlash.png"}],"items":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3113.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/3340.png"}],"needRenew":false,"gameId":"414535246","createDate":1668774868,"gameLength":3401,"gameType":"무작위 총력전","summonerId":"60235256","summonerName":"genetory","tierRankShort":"C1","stats":{"general":{"kill":9,"death":1,"assist":5,"kdaString":"14.00:1","cs":166,"csPerMin":7.5,"contributionForKillRate":"4%","goldEarned":2220,"totalDamageDealtToChampions":6146,"largestMultiKillString":"Double Kill","opScoreBadge":"ACE"},"ward":{"sightWardsBought":0,"visionWardsBought":2}},"mapInfo":null,"peak":["https://opgg-static.akamaized.net/images/lol/perk/8229.png","https://opgg-static.akamaized.net/images/lol/perkStyle/8300.png"],"isWin":false},{"mmr":12,"champion":{"imageUrl":"https://opgg-static.akamaized.net/images/lol/champion/Malzahar.png","level":6},"spells":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerTeleport.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/lol/spell/SummonerFlash.png"}],"items":[{"imageUrl":"https://opgg-static.akamaized.net/images/lol/item/2031.png"},{"imageUrl":"https://opgg-static.akamaized.net/images/l
}


