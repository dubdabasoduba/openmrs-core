<%@ page import="org.openmrs.util.OpenmrsConstants" %>
<%
	pageContext.setAttribute("platformVersion", OpenmrsConstants.OPENMRS_VERSION_SHORT);
%>

<html>
<head>
	<title>OpenMRS</title>
	
    <link rel="shortcut icon" type="image/ico" href="images/openmrs-favicon.ico"/>
	<link rel="icon" type="image/png" href="images/openmrs-favicon.png"/>
    
	<style type="text/css" media="all">
		* {
			font-family: Verdana, 'Lucida Grande', 'Trebuchet MS', Arial, Sans-Serif;
		}
        .logo {
            background-image:url(images/openmrs_logo_white.gif);
            background-repeat:no-repeat;
            height:98px;
            left: 3px;
        }
        .bar {
            background-image:url(images/openmrs_barx.gif);
            background-repeat:repeat-x;
            height:45px;
            width:100%;
            margin-left: 15px;
        }
        .bar-round {
            background-image:url(images/openmrs_bar.gif);
            background-repeat:no-repeat;
            height:45px;
            width:100%;
            font-size:24px;
        }
    </style>
</head>
<body style="background:#ecf3f7">
    <img style="margin-left:75px; padding-top:10px;" src="images/openmrs_logo_text.gif" />
    <table style="text-align:center; line-height:40px; margin-top:-25px;" width="100%">
        <tr>
        	<td width="100px"><div class="logo"></div></td>
        	<td>
            	<div class="bar-round">
        			<div class="bar">OpenMRS Platform ${platformVersion} Running!</div>
        		</div>
            </td>
        </tr>
    </table>
</body>
</html>