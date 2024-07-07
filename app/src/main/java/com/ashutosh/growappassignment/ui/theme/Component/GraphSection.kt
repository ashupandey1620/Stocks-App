package com.ashutosh.growappassignment.ui.theme.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme
import com.ashutosh.growappassignment.ui.theme.Screen.Product
import java.text.SimpleDateFormat
import java.time.Month
import java.util.Locale


@Composable
fun GraphSection() {
    val pointsData: List<Point> =
        listOf(
            Point(0.25f, 40f) ,Point(0.5f, 45f),Point(0.75f, 52f),Point(1f, 65f),
            Point(1.25f, 62f) ,Point(1.5f, 64f), Point(1.75f, 68f), Point(2f, 72f),
            Point(2.25f, 52f) ,Point(2.5f, 51f), Point(2.75f, 45f), Point(3f, 52f),
            Point(3.25f, 21f), Point(3.5f, 18f), Point(3.75f, 15f),  Point(4f, 16f),
            Point(4.25f, 19f), Point(4.5f, 23f), Point(4.75f, 25f),Point(5f, 31f),
            Point(5.25f, 40f) ,Point(5.5f, 45f),Point(5.75f, 43f),Point(6f, 53f),
            Point(6.25f, 35f) ,Point(6.5f, 38f), Point(6.75f, 40f), Point(7f, 55f),
            Point(7.25f, 59f) ,Point(7.5f, 60f), Point(7.75f, 65f), Point(8f, 72f),
            Point(8.25f, 81f), Point(8.5f, 84f), Point(8.75f, 88f),  Point(9f, 91f),
            Point(9.25f, 88f), Point(9.5f, 89f), Point(9.75f, 92f),Point(10f, 93f),
            Point(10.25f, 80f) ,Point(10.5f, 78f),Point(10.75f, 71f),Point(11f, 78f),
            Point(11.25f, 93f) ,Point(11.5f, 91f), Point(11.75f, 88f), Point(12f, 80f),


        )

    val yAxis = listOf(112,125,1991,116,117,154,146,176,174,203)
    val sortedY = yAxis.sorted()


    val xAxis = listOf("11:59 AM","01:01 PM","02:34 PM","04:01 PM","06:02 PM","07:21 PM",)

    val dateFormat = SimpleDateFormat("hh:mm a", Locale.US)

    val sortedX = xAxis.map { dateFormat.parse(it) }
        .sorted()
        .map { dateFormat.format(it) }


    val ySteps = 4;
    val yAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(ySteps)
        .labelData { i ->
            if (i==0)
                ""
            else
            "$ ${sortedY[i*sortedY.size/(ySteps+1)]}"
        }
        .axisLabelFontSize(9.sp)
        .axisLineColor(Color.Transparent)
        .axisLabelColor(MaterialTheme.colorScheme.onSecondary)
        .labelAndAxisLinePadding(20.dp)
        .backgroundColor(MaterialTheme.colorScheme.background)
        .build()

    
    val xSteps = 6;
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(xSteps)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            if (i==0)
                ""
            else
                sortedX[i/3].toString()
        }
        .axisLabelFontSize(9.sp)
        .axisLineColor(Color.Transparent)
        .backgroundColor(MaterialTheme.colorScheme.background)
        .axisLabelColor(MaterialTheme.colorScheme.onSecondary)
        .build()


    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color =    Color.Blue,
                        blendMode = BlendMode.Clear,
                        width = 2f,
                        ) ,
                    IntersectionPoint(radius = 0.dp) ,
                    SelectionHighlightPoint() ,
                    ShadowUnderLine(color = Color.Transparent) ,
                    SelectionHighlightPopUp(labelSize = 10.sp,
                        labelColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            ),
            plotType = PlotType.Line
        ) ,
        bottomPadding = 5.dp,
        paddingTop = 10.dp,
        paddingRight = 0.dp,
        containerPaddingEnd = 10.dp,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(
            enableHorizontalLines = false,
            enableVerticalLines = false,
            ) ,
        backgroundColor =   MaterialTheme.colorScheme.background
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(MaterialTheme.colorScheme.background)
        ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card( modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(MaterialTheme.colorScheme.background))
        {

            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(MaterialTheme.colorScheme.background),
                lineChartData = lineChartData
            )

        }
    }

}




@Preview()
@Composable
fun GraphSectionPreview() {
    GrowAppAssignmentTheme{
        GraphSection()
    }
}