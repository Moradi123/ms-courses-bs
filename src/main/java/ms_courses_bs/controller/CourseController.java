package ms_courses_bs.controller;

import ms_courses_bs.model.dto.CourseDTO;
import ms_courses_bs.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
@Tag(name = "Cursos - BS", description = "Operaciones de lógica de negocio")
public class CourseController {
    @Autowired
    CourseService courseService;
    
    @Operation(summary = "Buscar un curso por ID", description = "Obtiene los detalles de un curso.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso encontrado", 
                     content = { @Content(mediaType = "application/json", 
                                          schema = @Schema(implementation = CourseDTO.class)) }),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourseById(
            @Parameter(description = "ID del curso a buscar", required = true, example = "1") 
            @PathVariable(name = "id") Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        if (courseDTO != null) {
            return ResponseEntity.ok(courseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}