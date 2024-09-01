package osvaldo.app.news.mobile.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchView(
    searchValue: String,
    onValueChange: (String) -> Unit,
    search: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    TextField(
        value = searchValue,
        onValueChange = onValueChange,
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (searchValue.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        onValueChange("")
                    }
                )
            }
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                search()
            }
        ),
        textStyle = MaterialTheme.typography.bodyLarge
    )
}