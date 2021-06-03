<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>


    <main>
        <div class="registro_container">
            <div class="formulario_container">
                <form action="usuarios" method="post">
                    <h1 id="titulo_registro">Registro</h1>
                    <label for="user_name">Nombre de usuario<span class="asterisco">*</span></label>
                    <input class="registroform" type="text" placeholder="Introduce nombre de usuario" name="user_name" id="user_name" required>

                    <label for="user_email">Email<span class="asterisco">*</span></label>
                    <input class="registroform" type="text" placeholder="Introduce Email" name="user_email" id="user_email" required>

                    <label for="user_password">Contraseña<span class="asterisco">*</span></label>
                    <input class="registroform" type="password" placeholder="Introduce contraseña" name="user_password" id="user_password" required>

                    <label for="user_password_repeat">Repite contraseña<span class="asterisco">*</span></label>
                    <input class="registroform" type="password" placeholder="Repite contraseña" name="user_password_confirm" id="user_password_confirm" required>

					<p id="mensajeregistro">${mensaje}</p>
                    <p id="terminosycondiciones">Al crear tu cuenta aceptas nuestros <a href="#">Términos y condiciones</a>.</p>
                    <button type="submit" id="submit" class="boton_registro"> Registro </button>
                </form>

                <div class="login_container">
                    <p>¿Ya tienes una cuenta? Logéate <a href="#top">aquí­</a>.</p>
                </div>
             </div>

             <div class="info_container">
                 <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid cumque aperiam nobis ut, culpa amet dignissimos quia corporis vel dolore repellat numquam blanditiis ullam repellendus! Quidem, totam praesentium. Aut, nostrum.</p>
                 <p>Veniam recusandae saepe est animi repellendus sed temporibus vitae natus, beatae consequuntur dolor molestiae, quod distinctio nulla nihil fugit odit consectetur inventore suscipit at quibusdam ipsam? Numquam ex saepe minima?</p>
                 <p>Perferendis quod dolorem ut quia iure porro, blanditiis officia rerum harum ab voluptates, ex illum fuga tempore cum possimus? Expedita unde, explicabo accusantium nulla quae harum. Nam iste ipsum cum?</p>
             </div>
        </div>
       </main>
        
<jsp:include page="plantillas/footer.jsp"/>