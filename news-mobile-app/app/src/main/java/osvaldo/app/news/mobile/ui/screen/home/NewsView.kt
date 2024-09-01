package osvaldo.app.news.mobile.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import osvaldo.app.news.mobile.domain.model.News

@Composable
fun NewsView(
    news: List<News>,
    onNewsDetail: (News) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(news) {
            NewsItem(news = it, onNewsDetail = { onNewsDetail(it) })
        }
    }
}

@Composable
fun NewsItem(
    news: News,
    onNewsDetail: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        AsyncImage(
            model = news.urlToImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .weight(0.35f)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(
            Modifier.weight(0.65f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = news.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left
            )
            Text(
                text = news.description.substring(0, news.description.length / 2),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Justify
            )
            HorizontalDivider()
            Row(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Ver más",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        onNewsDetail()
                    }
                )
            }
        }
    }
}