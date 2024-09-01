package osvaldo.app.news.mobile.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import osvaldo.app.news.mobile.R
import osvaldo.app.news.mobile.data.local.DataFilter

@Composable
fun FilterView(

) {
    var filterLanguage by remember {
        mutableStateOf(false)
    }
    var filterSortBy by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_filter),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        FilterItemView(
            title = stringResource(id = R.string.title_language),
            valueCurrent = "All",
            values = DataFilter.language,
            onSelect = filterLanguage,
            onChageSelect = { filterLanguage = !filterLanguage },
            select = { }
        )
        FilterItemView(
            title = stringResource(id = R.string.title_sort_by),
            valueCurrent = "publishedAt",
            values = DataFilter.sortBy,
            onSelect = filterSortBy,
            onChageSelect = { filterSortBy = !filterSortBy  },
            select = { }
        )
    }
}

@Composable
fun FilterItemView(
    title: String,
    valueCurrent: String,
    values: List<String>,
    onSelect: Boolean,
    onChageSelect: () -> Unit,
    select: (String) -> Unit
) {
    val testStyle = MaterialTheme.typography.bodyMedium
    Column(
        modifier = Modifier
            .padding(4.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = title, style = testStyle, fontWeight = FontWeight.Bold)
                Text(text = valueCurrent, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Light)
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.clickable { onChageSelect() }
            )
        }
        AnimatedVisibility(visible = onSelect) {
            Column {
                HorizontalDivider(modifier = Modifier.padding(0.dp))
                values.filter { it != valueCurrent }.forEach {
                    Text(
                        text = it,
                        style = testStyle,
                        modifier = Modifier
                            .clickable { select(it) }
                            .padding(6.dp)
                            .fillMaxWidth()
                    )
                    HorizontalDivider(modifier = Modifier.padding(0.dp))
                }
            }
        }
    }
}