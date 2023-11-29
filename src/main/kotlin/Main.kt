import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val list = remember { SnapshotStateList<Int>() }
    MaterialTheme {
        Scaffold(
            floatingActionButton = {
                TextButton(onClick = {
                    list.add(list.size+1)
                }){
                    Text("Добавить")
                }
            },
            topBar = {
                TopAppBar {
                    Text("Меню")
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier.padding(it),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(list) {
                    MyCard(it)
                }
            }
        }
    }
}

@Composable
fun MyCard(
    num: Int,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primarySurface
    ){
        Text(
            "Карточка №$num",
            modifier = Modifier.padding(32.dp)
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
