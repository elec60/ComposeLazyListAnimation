package hashem.mousavi.composelazylistanimation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hashem.mousavi.composelazylistanimation.R
import kotlin.math.abs

@Composable
fun CustomList(modifier: Modifier) {
    val state = rememberLazyListState()

    val padding = 24.dp
    val paddingPx = with(LocalDensity.current) { padding.roundToPx() }

    val values by remember {
        derivedStateOf {
            var triple: Triple<Int, Float, Int> = Triple(0, 0f, 0)
            state.layoutInfo.visibleItemsInfo.firstOrNull()?.let {
                val progress = abs(it.offset.toFloat() / (it.size + paddingPx * 2))
                triple = Triple(it.index, progress, it.offset)
            }
            triple
        }
    }


    LazyColumn(
        state = state,
        modifier = modifier.background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(padding),
        contentPadding = PaddingValues(24.dp)
    ) {
        itemsIndexed(createData()) { itemIndex, myData ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .graphicsLayer {
                        if (values.first == itemIndex) {
                            rotationX = (values.second * 180f).coerceAtMost(90f)
                            cameraDistance = 400.dp.toPx()
                            transformOrigin =
                                TransformOrigin(pivotFractionX = 0.5f, pivotFractionY = 1f)
                        }
                    },
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp)
            )
            {
                Image(
                    painter = painterResource(id = myData.resId),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

data class MyData(
    val resId: Int,
)

fun createData(): List<MyData> {
    return listOf(
        MyData(resId = R.drawable.a),
        MyData(resId = R.drawable.b),
        MyData(resId = R.drawable.c),
        MyData(resId = R.drawable.d),
        MyData(resId = R.drawable.e),
        MyData(resId = R.drawable.f),
        MyData(resId = R.drawable.g),
        MyData(resId = R.drawable.h),
        MyData(resId = R.drawable.i),
    )
}