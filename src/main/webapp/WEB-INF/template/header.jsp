<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="doc_header.jsp"/>

<header class="header">
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid d-flex align-items-center justify-content-between">
            <div class="navbar-header">
                <!-- Navbar Header--><a href="index.html" class="navbar-brand">
                <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">Smart</strong><strong>Home</strong></div>
                <div class="brand-text brand-sm"><strong class="text-primary">S</strong><strong>H</strong></div></a>


                <!-- Sidebar Toggle Btn-->
                <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
            </div>
            <div class="right-menu list-inline no-margin-bottom">
                <div class="list-inline-item"><a href="#" class="search-open nav-link"><i class="icon-magnifying-glass-browser"></i></a></div>
                <div class="list-inline-item dropdown"><a id="navbarDropdownMenuLink1" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link messages-toggle"><i class="icon-email"></i><span class="badge dashbg-1">5</span></a>
                    <div aria-labelledby="navbarDropdownMenuLink1" class="dropdown-menu messages"><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="../../files/img/avatar-3.jpg" alt="..." class="img-fluid">
                            <div class="status online"></div>
                        </div>
                        <div class="content">   <strong class="d-block">Nadia Halsey</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">9:30am</small></div></a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="../../files/img/avatar-2.jpg" alt="..." class="img-fluid">
                            <div class="status away"></div>
                        </div>
                        <div class="content">   <strong class="d-block">Peter Ramsy</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">7:40am</small></div></a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="../../files/img/avatar-1.jpg" alt="..." class="img-fluid">
                            <div class="status busy"></div>
                        </div>
                        <div class="content">   <strong class="d-block">Sam Kaheil</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">6:55am</small></div></a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="../../files/img/avatar-5.jpg" alt="..." class="img-fluid">
                            <div class="status offline"></div>
                        </div>
                        <div class="content">   <strong class="d-block">Sara Wood</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">10:30pm</small></div></a><a href="#" class="dropdown-item text-center message"> <strong>See All Messages <i class="fa fa-angle-right"></i></strong></a></div>
                </div>


                <!-- Log out               -->
                <div class="list-inline-item logout">                   <a id="logout" href="login.html" class="nav-link">Wyloguj<i class="icon-logout"></i></a></div>
            </div>
        </div>
    </nav>
</header>
<div class="d-flex align-items-stretch">
    <!-- Sidebar Navigation-->
    <nav id="sidebar">
        <!-- Sidebar Header-->
        <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="../../files/img/avatar-6.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
                <h1 class="h5">Niezalogowany</h1>
                <%--<p>Web Designer</p>--%>
            </div>
        </div>
        <!-- Sidebar Navidation Menus--><span class="heading">MENU GŁÓWNE</span>
        <ul class="list-unstyled">
            <li class="active"><a href="index.html"> <i class="icon-home"></i>Urządzenia</a></li>
            <li><a href="../views/locations/location-form.jsp"> <i class="icon-grid"></i>Pomieszczenia</a></li>
            <li><a href="/config"> <i class="fa fa-bar-chart"></i>Konfiguracja</a></li>
            <li><a href="forms.html"> <i class="icon-padnote"></i>Logi</a></li>
            <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Domownicy</a>
                <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                </ul>
            </li>
            <li><a href="login.html"> <i class="icon-logout"></i>Zaloguj</a></li>
        </ul>
    </nav>
    <!-- Sidebar Navigation end-->

    <div class="page-content">
        <div class="page-header">
            <div class="container-fluid">
                <h2 class="h5 no-margin-bottom">Dashboard</h2>
            </div>
        </div>