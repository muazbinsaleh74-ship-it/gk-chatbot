``````kotlin
package com.example.gkchatbot

data class KnowledgeEntry(
    val keywords: List<String>,
    val bn: String,
    val en: String,
    val category: String
)

object KnowledgeBase {{
    val entries: List<KnowledgeEntry> = listOf(
        KnowledgeEntry(
            keywords = listOf("bangladesh", ""capital", ""dhaka", ""capital of bangladesh", ""রাজধানী", ""বাংলাদেশ"),
            bn = ""বাংলাদেশের রাজধানী ঢাকা।",
            en = ""The capital of Bangladesh is Dhaka.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("national", ""flower", ""water lily", ""shapla", ""শাপলা", ""জাতীয়", ""ফুল"),
            bn = ""বাংলাদেশের জাতীয় ফুল শাপলা।",
            en = ""Bangladesh's national flower is the water lily ((Shapla).",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("national", ""animal", ""tiger", ""royal bengal", ""রয়েল বেঙ্গল", ""বাঘ", ""জাতীয় প্রাণী"),
            bn = ""বাংলাদেশের জাতীয় প্রাণী রয়েল বেঙ্গল টাইগার।",
            en = ""Bangladesh's national animal is the Royal Bengal Tiger.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("national", ""bird", ""doyel", ""magpie", ""ডোয়েল", ""জাতীয় পাখি"),
            bn = ""বাংলাদেশের জাতীয় পাখি ডোয়েল।",
            en = ""Bangladesh's national bird is the Doyel ((Oriental Magpie Robin).",
            category = ""Bangladesh"
        ),
``````
``````kotlin
        KnowledgeEntry(
            keywords = listOf("independence", ""day", ""২৬ মার্চ", ""1971", ""স্বাধীনতা"),
            bn = ""বাংলাদেশের স্বাধীনতা দিবস ২৬ মার্চ ১৯৭১।",
            en = ""Bangladesh's Independence Day is 26 March 1971.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("victory", ""day", ""১৬ ডিসেম্বর", ""1971", ""বিজয়"),
            bn = ""বিজয় দিবস ১৬ ডিসেম্বর ১৯৭১।",
            en = ""Victory Day is 16 December 1971.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("language", ""movement", ""২১ ফেব্রুয়ারি", ""1952", ""ভাষা", ""মাতৃভাষা"),
            bn = ""ভাষা আন্দোলনের স্মরণে ২১ ফেব্রুয়ারি পালিত হয়।",
            en = ""21 February is observed in memory of the Language Movement.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("largest", ""river", ""পদ্মা", ""মেঘনা", ""যমুনা", ""নদী"),
            bn = ""বাংলাদেশের প্রধান নদী পদ্মা, যমুনা ও মেঘনা।",
            en = ""Major rivers of Bangladesh are the Padma, Jamuna, and Meghna.",
            category = ""Geography"
        ),
        KnowledgeEntry(
            keywords = listOf("longest", ""sea", ""beach", ""cox", ""coxs", ""কক্সবাজার", ""সমুদ্র সৈকত"),
            bn = ""বিশ্বের দীর্ঘতম প্রাকৃতিক সমুদ্র সৈকত কক্সবাজার।",
            en = ""Cox's Bazar is the world's longest natural sea beach.",
            category = ""Geography"
        ),
        KnowledgeEntry(
            keywords = listOf("largest", ""forest", ""sundarbans", ""সুন্দরবন", ""ম্যাঙ্গ্রোভ"),
            bn = ""সুন্দরবন বিশ্বের বৃহত্তম ম্যানগ্রোভ বন।",
            en = ""The Sundarbans is the largest mangrove forest in the world.",
            category = ""Geography"
        ),
        KnowledgeEntry(
            keywords = listOf("continent", ""asia", ""largest continent", ""এশিয়া", ""মহাদেশ"),
            bn = ""পৃথিবীর সবচেয়ে বড় মহাদেশ এশিয়া।",
            en = ""Asia is the largest continent in the world.",
            category = ""World"
        ),
        KnowledgeEntry(
            keywords = listOf("planet", ""largest planet", ""jupiter", ""বৃহস্পতি", ""গ্রহ"),
            bn = ""সৌরজগতের সবচেয়ে বড় গ্রহ বৃহস্পতি।",
            en = ""Jupiter is the largest planet in the solar system.",
            category = ""Science"
        ),
``````
``````kotlin
        KnowledgeEntry(
            keywords = listOf("planet", ""smallest planet", ""mercury", ""বুধ"),
            bn = ""সৌরজগতের সবচেয়ে ছোট গ্রহ বুধ।",
            en = ""Mercury is the smallest planet in the solar system.",
            category = ""Science"
        ),
        KnowledgeEntry(
            keywords = listOf("currency", ""bangladesh", ""taka", ""টাকা", ""মুদ্রা"),
            bn = ""বাংলাদেশের মুদ্রা টাকা।",
            en = ""The currency of Bangladesh is the Taka.",
            category = ""Bangladesh"
        ),
        KnowledgeEntry(
            keywords = listOf("prime minister", ""bangladesh", ""প্রধানমন্ত্রী"),
            bn = ""বর্তমান প্রধানমন্ত্রীর প্রশ্নটি সময়ভিত্তিক। অনলাইনে নিশ্চিত করা ভালো।",
            en = ""The current prime minister is time-dependent. It's best verified online.",
            category = ""Civics"
        ),
        KnowledgeEntry(
            keywords = listOf("parliament", ""national", ""assembly", ""জাতীয় সংসদ"),
            bn = ""বাংলাদেশের আইনসভা জাতীয় সংসদ নামে পরিচিত।",
            en = ""Bangladesh's legislature is called the Jatiya Sangsad ((National Parliament).",
            category = ""Civics"
        ),
        KnowledgeEntry(
            keywords = listOf("earth", ""revolution", ""rotation", ""পৃথিবী", ""ঘূর্ণন", ""আবর্তন"),
            bn = ""পৃথিবী নিজ অক্ষে ঘূর্ণন করে ((rotation) এবং সূর্যের চারদিকে আবর্তন করে ((revolution)।",
            en = ""Earth rotates on its axis ((rotation) and revolves around the Sun ((revolution).",
            category = ""Science"
        ),
        KnowledgeEntry(
            keywords = listOf("water", ""formula", ""H2O", ""জলের সূত্র", ""পানি"),
            bn = ""পানির রাসায়নিক সংকেত H2O।",
            en = ""The chemical formula of water is H2O.",
            category = ""Science"
        ),
        KnowledgeEntry(
            keywords = listOf("largest", ""ocean", ""pacific", ""প্রশান্ত", ""মহাসাগর"),
            bn = ""পৃথিবীর সবচেয়ে বড় মহাসাগর প্রশান্ত মহাসাগর।",
            en = ""The largest ocean is the Pacific Ocean.",
            category = ""World"
        ),
        KnowledgeEntry(
            keywords = listOf("seven", ""continents", ""৭ মহাদেশ", ""মহাদেশ"),
            bn = ""৭টি মহাদেশ হলো এশিয়া, ইউরোপ, আফ্রিকা, উত্তর আমেরিকা, দক্ষিণ আমেরিকা, অস্ট্রেলিয়া, অ্যান্টার্কটিকা।",
            en = ""The 7 continents are Asia, Europe, Africa, North America, South America, Australia, and Antarctica.",
            category = ""World"
        ),
        KnowledgeEntry(
            keywords = listOf("bangla", ""language", ""official", ""বাংলা", ""রাষ্ট্রভাষা"),
            bn = ""বাংলা বাংলাদেশের রাষ্ট্রভাষা।",
            en = ""Bangla is the state language of Bangladesh.",
            category = ""Bangladesh"
        )
    )
}
``````
