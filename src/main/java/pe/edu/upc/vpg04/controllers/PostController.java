package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.PostDTO;
import pe.edu.upc.vpg04.dtos.QuantityPostsByVeteranDTO;
import pe.edu.upc.vpg04.entities.Post;
import pe.edu.upc.vpg04.servicesinterfaces.IPostService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publicar")
public class PostController {
    @Autowired
    private IPostService pS;
    @PostMapping("/registrar")
    //@PreAuthorize("hasAnyAuthority('VETERANO')")
    public void registrar(@RequestBody PostDTO postDTO) {
        ModelMapper m = new ModelMapper();
        Post post = m.map(postDTO, Post.class);
        pS.insert(post);
    }

    @PutMapping("/actualizar")
    public void modificar(@RequestBody PostDTO postDTO) {
        ModelMapper m = new ModelMapper();
        Post post = m.map(postDTO, Post.class);
        pS.update(post);
    }

    @GetMapping("/listar")
    //@PreAuthorize("hasAnyAuthority('VETERANO')")
    public List<PostDTO> listar() {
        return pS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PostDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @GetMapping("/listar/{id}")
    public PostDTO listarPorId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        PostDTO postDTO = m.map(pS.listId(id), PostDTO.class);
        return postDTO;
    }
    @GetMapping("/quantity")
    public List<QuantityPostsByVeteranDTO> quantityPostByVeterans(){
        List<String[]> list = pS.cantidadPublicacionesPorVeteranos();
        List<QuantityPostsByVeteranDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityPostsByVeteranDTO dto = new QuantityPostsByVeteranDTO();
            dto.setUsername(columna[0]);
            dto.setLastnameUser(columna[1]);
            dto.setQuantityPosts(Integer.parseInt(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
}
