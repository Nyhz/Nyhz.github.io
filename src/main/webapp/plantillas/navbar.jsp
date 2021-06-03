    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">LogoHere</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mob-navbar" aria-label="Toggle">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mob-navbar">
                <ul class="navbar-nav mb-2 mb-lg-0 mx-auto">
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'index') ? 'active' : '' }" aria-current="page" href="index?page=index">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'registro') ? 'active' : '' }" href="registro.jsp?page=registro">Registro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'perfil') ? 'active' : '' }" href="perfil.jsp?page=perfil">Mi perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'usuarios') ? 'active' : '' }" href="usuarios?page=usuarios">Panel Control</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="Username" />
                    <input class="form-control me-2" type="password" placeholder="Password" />
                    <button class="btn btn-warning" type="submit">Login</button>
                </form>
            </div>
        </div>
    </nav>