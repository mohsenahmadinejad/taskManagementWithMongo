<ul>
<li>
<ul>
<li>
<ul>
<li>This project is a simple implementation of a simple task management system.</li>
</ul>
<p>&nbsp;</p>
<p>&nbsp;</p>
<ul>
<li><strong>Technologies in using :</strong>
<ul>
<li>java 11</li>
<li>spring boot</li>
<li>maven</li>
</ul>
</li>
<li><strong>Database :</strong>
<ul>
<li><strong></strong></li>
</ul>
</li>
<li><strong>Libraries :</strong>
<ul>
<li><strong>lombok</strong>: for reduce boilerplate code for model/data objects.</li>
<li><strong>Swagger: </strong>for helps users build, document, test and consume RESTful web services<strong>.</strong></li>
<li><strong>ModelMapper</strong>: To make object mapping easy, by automatically determining how one object model maps to another, based on conventions.</li>
</ul>
</li>
<li><strong>Spring Security</strong></li>
</ul>
<p><strong>&nbsp;</strong></p>
<p><strong>&nbsp;</strong></p>
<p><strong>How to use without security?</strong></p>
<p>After running the app the best entry point is <strong>Swagger </strong>and the url is <a href="http://localhost:8081/swagger-ui.html">http://localhost:8081/swagger-ui.html</a></p>
<p>You can see the APIs and you can test them.</p>
<p><strong>Note: </strong>Before using the swagger you should disable the security.</p>
<p>&nbsp;</p>
<p><strong>Disabling/Enabling security:</strong></p>
<ul>
<li>Go to <u>properties </u>file</li>
<li>Look for property activation.status</li>
<li>Set it to <u>on/off</u></li>
</ul>
<p><strong>&nbsp;</strong></p>
<p><strong>&nbsp;</strong></p>
<p><strong>How to use with security?</strong></p>
1.&nbsp; In postman call api &ldquo;/signUp&rdquo; and add a user with username and password2.&nbsp; In postman call api &ldquo;/signIn&rdquo; a.&nbsp; Send username/passwordb.&nbsp; Get Authorization token 3.&nbsp; For call other APIs a.&nbsp; Go to postman b.&nbsp; Add a header &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; i.&nbsp;&nbsp; Set key=Authorization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ii.&nbsp;&nbsp; Set value= &ldquo;Bearer &ldquo; + token4.&nbsp; Call the api&nbsp;
<p><strong>Note: </strong><em><u>In next versions, the swagger will be active with security options</u></em>.</p>
&nbsp;
<p>&nbsp;</p>
</li>
</ul>
</li>
</ul>