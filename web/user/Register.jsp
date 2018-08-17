<%--
  Created by IntelliJ IDEA.
  User: PKH
  Date: 2018/8/13
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    <table width="80%">
        <tr align="left">
            <th font size="4">注册信息<hr /></th>
        </tr>
        <tr>
            <td>注：标有<font color="red">*</font>处，均为必填项</td>
        </tr>
        <tr>
            <td>
                <table align="center" width="95%">
                    <tr>
                        <td width="105px"><font color="yellow" size="3" ><strong>登录信息</strong></font></td>
                        <td width=25>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>登录名：</td>
                        <td><input type="text" name="uname" size="20" maxlength="15"></td>
                        <td><small>由字母、数字或“_”组成，长度不少于6位，不多于30位</small></td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>密 &nbsp;&nbsp;码：</td>
                        <td><input type="text" name="password" size="20" maxlength="15"></td>
                        <td><small>不少于6位字符</small></td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>确认密码：</td>
                        <td><input type="text" name="password1" size="20" maxlength="15"></td>
                        <td><small>请再次输入密码</small></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table align="center" width="95%">
                    <tr>
                        <td width="105px"><font color="yellow" size="3" ><strong>登录信息</strong></font></td>
                        <td width=25>&nbsp;</td>
                        <td width="75px">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>真实姓名：</td>
                        <td><input type="text" name="rename" size="20" maxlength="15"></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>性 &nbsp;&nbsp;别：</td>
                        <td>
                            <input type="radio" name="sex" value="0" checked/>男
                            <input type="radio" name="sex" value="1">女
                        </td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>省 &nbsp;&nbsp;份：</td>
                        <td>
                            <select style="width:160px" name="province" id="prov" onchange="changeCity()">
                                <option value="a">请选择省份</option>
                                <script type="text/javascript" language="JavaScript">
                                    for(i=0;i<provinces.length;i++){
                                        document.write("<option value='"+i+"'>"+provinces[i]+"</option>")
                                    };
                                </script>
                            </select>
                        </td>
                        <td>城市</td>
                        <td>
                            <select name="city" id="city">
                                <option value="b">请选择城市</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>证件类型：</td>
                        <td>
                            <select name="Idcard">
                                <option value="0" selected>二代身份证</option>
                                <option value="1">签证</option>
                            </select>
                        </td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>证件号码：</td>
                        <td><input type="text" name="IDnumber" size="20" maxlength="20"></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><font color="red">*</font>出生日期：</td>
                        <td><input class="laydate-icon" name="birth" id="demo" ></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;年龄：</td>
                        <td colspan="3">
                            <input type="text" name="age" size="20" maxlength="20">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
