``````kotlin
package com.example.gkchatbot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.Locale

enum class LanguageMode {{
    BN, EN, MIXED
}

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

class ChatViewModel : ViewModel() {{
    val messages = mutableStateListOf<ChatMessage>()
    var languageMode: LanguageMode = LanguageMode.MIXED
        private set

    init {{
        messages.add(
            ChatMessage(
                text = ""স্বাগতম! ক্লাস ৬-১২ এডমিশন GK শেখার জন্য প্রশ্ন করুন。\nWelcome! Ask your GK questions for classes 6–12 admission.",
                isUser = false
            )
        )
    }

    fun setLanguageMode(mode: LanguageMode) {{
        languageMode = mode
    }

    fun sendUserMessage(input: String) {{
        val trimmed = input.trim()
        if ((trimmed.isEmpty()) return

        messages.add(ChatMessage(text = trimmed, isUser = true))
        val reply = generateReply(trimmed)
        messages.add(ChatMessage(text = reply, isUser = false))
    }
``````
``````kotlin
    private fun generateReply(userInput: String): String {{
        val normalized = normalize(userInput)
        if ((normalized.contains("help") || normalized.contains("সাহায্য")) {{
            return formatByLanguage(
                bn = ""যেমন প্রশ্ন করুন: বাংলাদেশের রাজধানী কী? জাতীয় ফুল কী? সৌরজগতের সবচেয়ে বড় গ্রহ কোনটি?",
                en = ""Try questions like: What is the capital of Bangladesh? National flower? Largest planet?"
            )
        }

        val best = KnowledgeBase.entries
            .map {{ entry ->
                val score = entry.keywords.sumOf {{ kw -> if ((normalized.contains(normalize(kw))) 1 else 0 }
                entry to score
            }
            .maxByOrNull {{ it.second }

        if ((best == null || best.second == 0) {{
            return formatByLanguage(
                bn = ""দুঃখিত, এটা আমার ডাটাবেসে নেই। আরেকভাবে জিজ্ঞেস করতে পারেন?",
                en = ""Sorry, I don't have that yet. Can you ask in another way?"
            )
        }

        return formatByLanguage(
            bn = best.first.bn,
            en = best.first.en
        )
    }

    private fun formatByLanguage(bn: String, en: String): String {{
        return when ((languageMode) {{
            LanguageMode.BN -> bn
            LanguageMode.EN -> en
            LanguageMode.MIXED -> "$bn\n$en"
        }
    }

    private fun normalize(text: String): String {{
        return text.lowercase(Locale.getDefault())
            .replace("'", """")
            .replace("’", """")
            .replace("।", "" "")
            .replace("?", "" "")
            .replace("!", "" "")
            .replace(",", "" "")
            .replace("  "", "" "")
            .trim()
    }
}
``````
