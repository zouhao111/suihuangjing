<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<title>实时数据</title>
</head>
<body style="overflow-x:hidden;">
	<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">流量实时数据</strong></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="15%" align="left"><div class="td-space"></div></th>
						<th width="130" align="left"><div class="td-space">工业给水</div></th>
						<th width="130" align="left"><div class="td-space">生活给水</div></th>
						<th width="130" align="left"><div class="td-space">工业排水</div></th>
						<th width="130" align="left"><div class="td-space">标准生活用水量</div></th>
						<th width="130" align="left"><div class="td-space">不明用水量</div></th>
					</tr>
			</thead>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">采集时间</div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataThree.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataTwo.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataOne.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataOne.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataOne.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">水位（m）</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.waterlevel}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">流速（m/s）</div></th>
						<th width="130" align="left"><div class="td-space">${dataThree.currentSpeed}</div></th>
						<th width="130" align="left"><div class="td-space">${dataTwo.currentSpeed}</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.currentSpeed}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">流量速率（m3/s）</div></th>
						<th width="130" align="left"><div class="td-space">${dataThree.traffic}</div></th>
						<th width="130" align="left"><div class="td-space">${dataTwo.traffic}</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.traffic}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">总流量（m3）</div></th>
						<th width="130" align="left"><div class="td-space">${dataThree.ztraffic}</div></th>
						<th width="130" align="left"><div class="td-space">${dataTwo.ztraffic}</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.ztraffic}</div></th>
						<th width="130" align="left"><div class="td-space">${totaltrffica.standardWater}</div></th>
						<th width="130" align="left"><div class="td-space">${totaltrffica.unkownWater}</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">昨日流量（m3）</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdaySummary.supplyWater}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdaySummary.domestiWater}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdaySummary.drainageWater}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdaySummary.standardWater}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdaySummary.unkownWater}</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">今日流量（m3）</div></th>
						<th width="130" align="left"><div class="td-space">${thisdaytotalodk.supplyWater}</div></th>
						<th width="130" align="left"><div class="td-space">${thisdaytotalodk.domestiWater}</div></th>
						<th width="130" align="left"><div class="td-space">${thisdaytotalodk.drainageWater}</div></th>
						<th width="130" align="left"><div class="td-space">${thisdaytotalodk.standardWater}</div></th>
						<th width="130" align="left"><div class="td-space">${thisdaytotalodk.unkownWater}</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<th width="130" align="left"><div class="td-space">电压（V）</div></th>
						<th width="130" align="left"><div class="td-space">${dataThree.voltage}</div></th>
						<th width="130" align="left"><div class="td-space">${dataTwo.voltage}</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.voltage}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">状态</div></th>
						<th width="130" align="left"><div class="td-space">正常</div></th>
						<th width="130" align="left"><div class="td-space">正常</div></th>
						<th width="130" align="left"><div class="td-space">正常</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
	</table>
	
	<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">排水水质实时数据</strong></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="6%" align="left"><div class="td-space"></div></th>
						<th width="130" align="left"><div class="td-space">今日</div></th>
						<th width="130" align="left"><div class="td-space">昨日</div></th>
					</tr>
			</thead>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">采集时间</div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${dataOne.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">PH值</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.ph}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">COD(mg/l)</div></th>
						<th width="130" align="left"><div class="td-space">${dataOne.cod}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">最大PH</div></th>
						<th width="130" align="left"><div class="td-space">${thiswaterquality.maxPH}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdayAnalysis.maxPH}</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">最小PH</div></th>
						<th width="130" align="left"><div class="td-space">${thiswaterquality.minPH}</div></th>
						<th width="130" align="left"><div class="td-space">${yesterdayAnalysis.minPH}</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="200" align="left"><div class="td-space">采样时间</div></th>
						<th width="130" align="left"><div class="td-space"><fmt:formatDate value="${samplingRecord.strTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">采样水量（ml）</div></th>
						<th width="130" align="left"><div class="td-space">${samplingRecord.capacity}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="200" align="left"><div class="td-space">采样杯号</div></th>
						<th width="130" align="left"><div class="td-space">${samplingRecord.num}</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">报警采样时间</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
			<tbody>
					<tr >
						<th width="130" align="left"><div class="td-space">采样时PH值</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
						<th width="130" align="left"><div class="td-space">-</div></th>
					</tr>
			</tbody>
	</table>
	
	
	
	
	<div style="width:100%">
         <p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">备注</strong></p>
            <p>①给水总流量=工厂市政进水口实测流量；</p>
           	<p>②工业污水排放总流量=工厂申报排污口实测流量；</p>
     		<p>③标准生活用水总量=根据国标《城市居民生活用水量标准》GB/T50331统计的C级人均用水量(220升)<br />
     		和永艺发金属制品(深圳)有限公司工厂人数(230人)计算的生活用水总量(分时累计)；</p>
        	<p>④不明用水总量=给水总流量-工业污水排放总流量-标准生活用水总量;</p>
    </div>

	
	
</body>

</html>