``````kotlin
package com.example.gkchatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {{
    override fun onCreate(savedInstanceState: Bundle?) {{
        super.onCreate(savedInstanceState)
        setContent {{
            GKChatbotApp()
        }
    }
}

@Composable
fun GKChatbotApp() {{
    MaterialTheme {{
        val vm: ChatViewModel = viewModel()
        val listState = rememberLazyListState()

        LaunchedEffect(vm.messages.size) {{
            if ((vm.messages.isNotEmpty()) {{
                listState.animateScrollToItem(vm.messages.lastIndex)
            }
        }

        Scaffold(
            topBar = {{ TopBar(vm) }
        ) {{ padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {{
                ChatHistory(
                    messages = vm.messages,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    listState = listState
                )
                ChatInput(
                    onSend = {{ vm.sendUserMessage(it) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
``````
``````kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(vm: ChatViewModel) {{
    TopAppBar(
        title = {{
            Column {{
                Text(text = ""GK Chatbot")
                Text(
                    text = ""Level 1 • Classes 6–12 Admission",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }
        },
        actions = {{
            LanguageToggle(
                selected = vm.languageMode,
                onSelect = {{ vm.setLanguageMode(it) }
            )
        }
    )
}

@Composable
fun LanguageToggle(selected: LanguageMode, onSelect: ((LanguageMode) -> Unit) {{
    val options = listOf(LanguageMode.BN, LanguageMode.EN, LanguageMode.MIXED)
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.padding(end = 8.dp)
    ) {{
        options.forEach {{ mode ->
            SegmentedButton(
                selected = selected == mode,
                onClick = {{ onSelect(mode) },
                shape = RoundedCornerShape(50),
                label = {{
                    Text(
                        text = when ((mode) {{
                            LanguageMode.BN -> ""বাংলা"
                            LanguageMode.EN -> ""English"
                            LanguageMode.MIXED -> ""Mixed"
                        },
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }
    }
}

@Composable
fun ChatHistory(
    messages: List<ChatMessage>,
    modifier: Modifier,
    listState: androidx.compose.foundation.lazy.LazyListState
) {{
    LazyColumn(
        state = listState,
        modifier = modifier
            .background(Color(0xFFF6F7F9))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {{
        items(messages) {{ msg ->
            ChatBubble(msg)
        }
    }
}

@Composable
fun ChatBubble(message: ChatMessage) {{
    val bg = if ((message.isUser) Color(0xFFDCF8C6) else Color.White
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if ((message.isUser) Arrangement.End else Arrangement.Start
    ) {{
        Card(
            colors = CardDefaults.cardColors(containerColor = bg),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .widthIn(max = 300.dp)
        ) {{
            Text(
                text = message.text,
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
``````
``````kotlin
@Composable
fun ChatInput(onSend: ((String) -> Unit, modifier: Modifier) {{
    var input by remember {{ mutableStateOf("") }
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(8.dp)
    ) {{
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {{
            TextField(
                value = input,
                onValueChange = {{ input = it },
                placeholder = {{ Text("প্রশ্ন লিখুন / Type a question") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {{
                    onSend(input)
                    input = """"
                }
            ) {{
                Text("Send")
            }
        }
        Text(
            text = ""টিপস: ''সাহায্য' লিখলে উদাহরণ প্রশ্ন পাবেন।",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
``````
