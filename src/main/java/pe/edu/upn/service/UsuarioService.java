package pe.edu.upn.service;



import java.util.Optional;

import pe.edu.upn.model.entity.Usuario;

public interface UsuarioService  extends CrudService<Usuario, Long> {

	Optional<Usuario> findByUsuarioNombre(String usuarioNombre);

}
