
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户地区统计</title>
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    //发送ajax请求获取数据,展示echarts表格
    $.get("${pageContext.request.contextPath}/stat/loadCustomerAreaStatJson.action",function (data){
        //创建一个dom对象
        var divdom = document.getElementById("container")
        //再创建一个echarts对象
        var myCharts = echarts.init(divdom);
        //设置配置和数据
        var option = {
            title: {
                text: '客户地区统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: '客户数量',
                    type: 'pie',
                    radius: '50%',
                    data: data,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        }

        //把option添加到echarts对象中
        myCharts.setOption(option);
    })

</script>
</body>
</html>
