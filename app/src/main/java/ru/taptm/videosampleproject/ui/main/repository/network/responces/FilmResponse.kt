package ru.taptm.videosampleproject.ui.main.repository.network.responces


import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @SerializedName("has_next")
    val hasNext: Boolean,
    @SerializedName("next")
    val next: Any,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("content_type")
        val contentType: ContentType,
        @SerializedName("external_ids")
        val externalIds: List<ExternalId>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_adult")
        val isAdult: Boolean,
        @SerializedName("last_updated_ts")
        val lastUpdatedTs: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("object_id")
        val objectId: Int,
        @SerializedName("object")
        val objectX: Object
    ) {
        data class ContentType(
            @SerializedName("app_label")
            val appLabel: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("model")
            val model: String
        )

        data class ExternalId(
            @SerializedName("code")
            val code: String,
            @SerializedName("external_id")
            val externalId: String
        )

        data class Object(
            @SerializedName("absolute_url")
            val absoluteUrl: String,
            @SerializedName("age_restriction")
            val ageRestriction: String,
            @SerializedName("can_subscribe")
            val canSubscribe: Boolean,
            @SerializedName("description")
            val description: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("last_updated_ts")
            val lastUpdatedTs: String,
            @SerializedName("name")
            val name: String?,
            @SerializedName("picture")
            val picture: String?,
            @SerializedName("slug")
            val slug: String,
            @SerializedName("subscribers_count")
            val subscribersCount: Int,
            @SerializedName("type")
            val type: Type,
            @SerializedName("uniform_url")
            val uniformUrl: String,
            @SerializedName("video_count")
            val videoCount: Int
        ) {
            data class Type(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("title")
                val title: String
            )
        }
    }
}