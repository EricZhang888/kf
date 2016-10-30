<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="cn">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1号房后台管理中心</title>
<meta name="keywords" content="1号房">
<meta name="description" content="1号房">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="shortcut icon" href="favicon.ico">
<link href="./resource/cssfolder/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="./resource/cssfolder/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<link href="./resource/cssfolder/animate.min.css" rel="stylesheet">
<link href="./resource/cssfolder/style.min.css?v=4.1.0" rel="stylesheet">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
      <!--左侧导航开始-->
      <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
          <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
          <ul class="nav" id="side-menu">
            <li class="nav-header">
              <div class="dropdown profile-element">
                <span>
                  <img alt="image" class="img-circle" src="./resource/imgs/profile_small.jpg" /></span>
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                  <span class="clear">
                    <span class="block m-t-xs">
                      <strong class="font-bold">路杨</strong></span>
                    <span class="text-muted text-xs block">超级管理员
                      <b class="caret"></b></span>
                  </span>
                </a>
                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                  <li>
                    <a class="J_menuItem" href="#">修改密码</a>
                  </li>
                  <li>
                    <a class="J_menuItem" href="#">个人资料</a>
                  </li>
                  <li>
                    <a class="J_menuItem" href="#">联系我们</a>
                  </li>
                  <li>
                    <a class="J_menuItem" href="#">信箱</a>
                  </li>
                  <li class="divider"></li>
                  <li>
                    <a href="logout">安全退出</a></li>
                </ul>
              </div>
              <div class="logo-element">1号房</div></li>
            <li>
              <a class="J_menuItem" href="login.jsp">
                <i class="fa fa-columns"></i>
                <span class="nav-label">首页</span></a>
            </li>
            <li>
              <a href="#">
                <i class="fa fa fa-edit"></i>
                <span class="nav-label">订单管理</span>
                <span class="label label-warning pull-right">200</span>
              </a>
              <ul class="nav nav-second-level">
                <li>
                  <a class="J_menuItem" href="./order/orders">订单查询</a>
                </li>
                <li>
                  <a class="J_menuItem" href="./order/addOrder">现场入住</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="mailbox.html">
                <i class="fa fa-envelope"></i>
                <span class="nav-label">房源管理</span>
                <span class="fa arrow"></span>
              </a>
              <ul class="nav nav-second-level">
                <li>
                  <a class="J_menuItem" href="mailbox.html">门店管理</a></li>
                <li>
                  <a class="J_menuItem" href="mail_detail.html">增加房源</a></li>
                <li>
                  <a class="J_menuItem" href="mail_compose.html">查询房源</a></li>
              </ul>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-edit"></i>
                <span class="nav-label">会员管理</span>
                <span class="fa arrow"></span>
              </a>
              <ul class="nav nav-second-level">
                <li>
                  <a class="J_menuItem" href="#">会员列表</a></li>
                <li>
                  <a class="J_menuItem" href="#">表单验证</a></li>
                <li>
                  <a class="J_menuItem" href="#">高级插件</a></li>
                <li>
                  <a class="J_menuItem" href="#">表单向导</a></li>
              </ul>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-desktop"></i>
                <span class="nav-label">房东管理</span>
                <span class="fa arrow"></span>
              </a>
              <ul class="nav nav-second-level">
                <li>
                  <a class="J_menuItem" href="contacts.html">增加房东</a></li>
                <li>
                  <a class="J_menuItem" href="profile.html">房东列表</a></li>
              </ul>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-flask"></i>
                <span class="nav-label">其他</span>
                <span class="fa arrow"></span>
              </a>
              <ul class="nav nav-second-level">
                <li>
                  <a class="J_menuItem" href="#">城市管理</a>
                </li>
                <li>
                  <a class="J_menuItem" href="#">群发短信</a></li>
                <li>
                  <a class="J_menuItem" href="#">内部通知</a></li>
                <li>
                  <a class="J_menuItem" href="#">员工管理</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
      <!--左侧导航结束-->
      <!--右侧部分开始-->
      <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
          <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
              <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
                <i class="fa fa-bars"></i>
              </a>
              <form role="search" class="navbar-form-custom" method="post" action="order/searchOrder">
                <div class="form-group">
                  <input type="text" placeholder="请输入订单号 快速查询" class="form-control" name="orderNumber" id="top-search"></div>
              </form>
            </div>
          </nav>
        </div>
        <div class="row content-tabs">
          <button class="roll-nav roll-left J_tabLeft">
            <i class="fa fa-backward"></i>
          </button>
          <nav class="page-tabs J_menuTabs">
            <div class="page-tabs-content">
              <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a></div>
          </nav>
          <button class="roll-nav roll-right J_tabRight">
            <i class="fa fa-forward"></i>
          </button>
          <div class="btn-group roll-nav roll-right">
            <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作
              <span class="caret"></span></button>
            <ul role="menu" class="dropdown-menu dropdown-menu-right">
              <li class="J_tabShowActive">
                <a>定位当前选项卡</a>
              </li>
              <li class="divider"></li>
              <li class="J_tabCloseAll">
                <a>关闭全部选项卡</a>
              </li>
              <li class="J_tabCloseOther">
                <a>关闭其他选项卡</a>
              </li>
            </ul>
          </div>
          <a href="logout" class="roll-nav roll-right J_tabExit">
            <i class="fa fa fa-sign-out"></i>退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
          <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="./adminHome.jsp" frameborder="0" data-id="adminHome" seamless></iframe>
        </div>
        <div class="footer">
          <div class="pull-right">&copy; 2016-2016
            <a href="http://1hf.bohosi.com/" target="_blank">包豪斯酒店管理（深圳）有限公司</a></div>
        </div>
      </div>
      <!--右侧部分结束-->
      <!--右侧边栏开始-->
      <div id="right-sidebar">
        <div class="sidebar-container">
          <ul class="nav nav-tabs navs-3">
            <li class="active">
              <a data-toggle="tab" href="#tab-1">
                <i class="fa fa-gear"></i>主题</a>
            </li>
            <li class="">
              <a data-toggle="tab" href="#tab-2">通知</a></li>
            <li>
              <a data-toggle="tab" href="#tab-3">项目进度</a></li>
          </ul>
          <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
              <div class="sidebar-title">
                <h3>
                  <i class="fa fa-comments-o"></i>主题设置</h3>
                <small>
                  <i class="fa fa-tim"></i>你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
              </div>
              <div class="skin-setttings">
                <div class="title">主题设置</div>
                <div class="setings-item">
                  <span>收起左侧菜单</span>
                  <div class="switch">
                    <div class="onoffswitch">
                      <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                      <label class="onoffswitch-label" for="collapsemenu">
                        <span class="onoffswitch-inner"></span>
                        <span class="onoffswitch-switch"></span>
                      </label>
                    </div>
                  </div>
                </div>
                <div class="setings-item">
                  <span>固定顶部</span>
                  <div class="switch">
                    <div class="onoffswitch">
                      <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                      <label class="onoffswitch-label" for="fixednavbar">
                        <span class="onoffswitch-inner"></span>
                        <span class="onoffswitch-switch"></span>
                      </label>
                    </div>
                  </div>
                </div>
                <div class="setings-item">
                  <span>固定宽度</span>
                  <div class="switch">
                    <div class="onoffswitch">
                      <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                      <label class="onoffswitch-label" for="boxedlayout">
                        <span class="onoffswitch-inner"></span>
                        <span class="onoffswitch-switch"></span>
                      </label>
                    </div>
                  </div>
                </div>
                <div class="title">皮肤选择</div>
                <div class="setings-item default-skin nb">
                  <span class="skin-name ">
                    <a href="#" class="s-skin-0">默认皮肤</a></span>
                </div>
                <div class="setings-item blue-skin nb">
                  <span class="skin-name ">
                    <a href="#" class="s-skin-1">蓝色主题</a></span>
                </div>
                <div class="setings-item yellow-skin nb">
                  <span class="skin-name ">
                    <a href="#" class="s-skin-3">黄色/紫色主题</a></span>
                </div>
              </div>
            </div>
            <div id="tab-2" class="tab-pane">
              <div class="sidebar-title">
                <h3>
                  <i class="fa fa-comments-o"></i>最新通知</h3>
                <small>
                  <i class="fa fa-tim"></i>您当前有10条未读信息</small>
              </div>
              <div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a1.jpg">
                      <div class="m-t-xs">
                        <i class="fa fa-star text-warning"></i>
                        <i class="fa fa-star text-warning"></i>
                      </div>
                    </div>
                    <div class="media-body">据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。
                      <br>
                      <small class="text-muted">今天 4:21</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a2.jpg"></div>
                    <div class="media-body">HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！
                      <br>
                      <small class="text-muted">昨天 2:45</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">
                      <div class="m-t-xs">
                        <i class="fa fa-star text-warning"></i>
                        <i class="fa fa-star text-warning"></i>
                        <i class="fa fa-star text-warning"></i>
                      </div>
                    </div>
                    <div class="media-body">写的好！与您分享
                      <br>
                      <small class="text-muted">昨天 1:10</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a4.jpg"></div>
                    <div class="media-body">国外极限小子的炼成！这还是亲生的吗！！
                      <br>
                      <small class="text-muted">昨天 8:37</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a8.jpg"></div>
                    <div class="media-body">一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。
                      <br>
                      <small class="text-muted">今天 4:21</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a7.jpg"></div>
                    <div class="media-body">这哥们的新视频又来了，创意杠杠滴，帅炸了！
                      <br>
                      <small class="text-muted">昨天 2:45</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">
                      <div class="m-t-xs">
                        <i class="fa fa-star text-warning"></i>
                        <i class="fa fa-star text-warning"></i>
                        <i class="fa fa-star text-warning"></i>
                      </div>
                    </div>
                    <div class="media-body">最近在补追此剧，特别喜欢这段表白。
                      <br>
                      <small class="text-muted">昨天 1:10</small></div>
                  </a>
                </div>
                <div class="sidebar-message">
                  <a href="#">
                    <div class="pull-left text-center">
                      <img alt="image" class="img-circle message-avatar" src="img/a4.jpg"></div>
                    <div class="media-body">我发起了一个投票 【你认为下午大盘会翻红吗？】
                      <br>
                      <small class="text-muted">星期一 8:37</small></div>
                  </a>
                </div>
              </div>
            </div>
            <div id="tab-3" class="tab-pane">
              <div class="sidebar-title">
                <h3>
                  <i class="fa fa-cube"></i>最新任务</h3>
                <small>
                  <i class="fa fa-tim"></i>您当前有14个任务，10个已完成</small>
              </div>
              <ul class="sidebar-list">
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>市场调研</h4>按要求接收教材；
                    <div class="small">已完成： 22%</div>
                    <div class="progress progress-mini">
                      <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                    </div>
                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div></a>
                </li>
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>可行性报告研究报上级批准</h4>编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对
                    <div class="small">已完成： 48%</div>
                    <div class="progress progress-mini">
                      <div style="width: 48%;" class="progress-bar"></div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>立项阶段</h4>东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司
                    <div class="small">已完成： 14%</div>
                    <div class="progress progress-mini">
                      <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <span class="label label-primary pull-right">NEW</span>
                    <h4>设计阶段</h4>
                    <!--<div class="small pull-right m-t-xs">9小时以后</div>-->项目进度报告(Project Progress Report)
                    <div class="small">已完成： 22%</div>
                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div></a>
                </li>
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>拆迁阶段</h4>科研项目研究进展报告 项目编号: 项目名称: 项目负责人:
                    <div class="small">已完成： 22%</div>
                    <div class="progress progress-mini">
                      <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                    </div>
                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div></a>
                </li>
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>建设阶段</h4>编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对
                    <div class="small">已完成： 48%</div>
                    <div class="progress progress-mini">
                      <div style="width: 48%;" class="progress-bar"></div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="small pull-right m-t-xs">9小时以后</div>
                    <h4>获证开盘</h4>编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对
                    <div class="small">已完成： 14%</div>
                    <div class="progress progress-mini">
                      <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!--右侧边栏结束-->
      <!--mini聊天窗口开始-->
      <div class="small-chat-box fadeInRight animated">
        <div class="heading" draggable="true">
          <small class="chat-date pull-right">2015.9.1</small>与 Beau-zihan 聊天中</div>
        <div class="content">
          <div class="left">
            <div class="author-name">Beau-zihan
              <small class="chat-date">10:02</small></div>
            <div class="chat-message active">你好</div></div>
          <div class="right">
            <div class="author-name">游客
              <small class="chat-date">11:24</small></div>
            <div class="chat-message">你好，请问H+有帮助文档吗？</div></div>
          <div class="left">
            <div class="author-name">Beau-zihan
              <small class="chat-date">08:45</small></div>
            <div class="chat-message active">有，购买的H+源码包中有帮助文档，位于docs文件夹下</div></div>
          <div class="right">
            <div class="author-name">游客
              <small class="chat-date">11:24</small></div>
            <div class="chat-message">那除了帮助文档还提供什么样的服务？</div></div>
          <div class="left">
            <div class="author-name">Beau-zihan
              <small class="chat-date">08:45</small></div>
            <div class="chat-message active">1.所有源码(未压缩、带注释版本)；
              <br>2.说明文档；
              <br>3.终身免费升级服务；
              <br>4.必要的技术支持；
              <br>5.付费二次开发服务；
              <br>6.授权许可；
              <br>……
              <br></div></div>
        </div>
        <div class="form-chat">
          <div class="input-group input-group-sm">
            <input type="text" class="form-control">
            <span class="input-group-btn">
              <button class="btn btn-primary" type="button">发送</button></span>
          </div>
        </div>
      </div>
      <div id="small-chat">
        <span class="badge badge-warning pull-right">5</span>
        <a class="open-small-chat">
          <i class="fa fa-comments"></i>
        </a>
      </div>
    </div>
    <script src="./resource/javascript/jquery.min.js?v=2.1.4"></script>
    <script src="./resource/javascript/bootstrap.min.js?v=3.3.6"></script>
    <script src="./resource/javascript/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="./resource/javascript/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="./resource/javascript/plugins/layer/layer.min.js"></script>
    <script src="./resource/javascript/hplus.min.js?v=4.1.0"></script>
    <script src="./resource/javascript/contabs.min.js"></script>
    <script src="./resource/javascript/plugins/pace/pace.min.js"></script>
  </body>
</html>