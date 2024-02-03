package com.demo.voiture.controller;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.dto.SearchAnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.message.FileToBase64StringConversionUnitTest;
import com.demo.voiture.services.AnnonceService;
import com.demo.voiture.services.ImageService;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/annonce")
@RequiredArgsConstructor
public class AnnonceController {

    private final AnnonceService annonceService;
    private final ImageService imageService;

    @GetMapping("")
    public Retour list_annonces() {
        return annonceService.getDetailsAnnonce(null);
    }

    @GetMapping("/{id}")
    public Retour annonce_id(@PathVariable String id) {
        return annonceService.getDetailsAnnonce(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/ionic")
    public Retour creer(@RequestBody AnnonceDto annonceDto) {
        return  annonceService.creer(annonceDto); 
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("")
    public Retour creer(@RequestParam("idVoiture") String idVoiture,
                        @RequestParam("idFicheTechnique") String idFicheTechnique,
                        @RequestParam("idCategorie") String idCategorie,
                        @RequestParam("etatVoiture") Double etatVoiture, 
                        @RequestParam("kilometrage") Double kilometrage,
                        @RequestParam("description") String description,
                        @RequestParam("prixVente") Double prixVente,
                        @RequestPart("photos") MultipartFile[] multipartFile
                        ) {
        
        AnnonceDto annonceDto = new AnnonceDto(idVoiture, idFicheTechnique, idCategorie, kilometrage, etatVoiture, description, prixVente);
        List<String> url_photo = new ArrayList<String>();
        try {
            Annonce control = new Annonce(annonceDto);
            //System.out.println("Multi part " + multipartFile.length);
            if(multipartFile.length != 0) {
                //System.out.println( multipartFile );
                if(multipartFile.length == 1) {
                    //System.out.println(multipartFile[0].getOriginalFilename());
                    if(multipartFile[0].isEmpty() != true) {
                        //System.out.println(" tsy null eee");
                        url_photo = imageService.upload(multipartFile);
                    }
                }
                else {
                    url_photo = imageService.upload(multipartFile);
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }

        annonceDto.setUrl_photo(url_photo);
        return annonceService.creer(annonceDto);
        //return new Retour("hhuhu");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    public Retour modifier(@PathVariable String id, @RequestBody AnnonceDto annonceDto) {
        return  annonceService.modifier(id,annonceDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public Retour supprimer(@PathVariable String id) {
        return  annonceService.supprimer(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/valider/{id}")
    public Retour valider(@PathVariable String id) {
        return annonceService.valider(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/refuser/{id}")
    public Retour refuser(@PathVariable String id) {
        return annonceService.refuser(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/vendre/{id}")
    public Retour vendre(@PathVariable String id) {
        return annonceService.vendre(id);
    }


    @GetMapping("/valider")
    public Retour listvalide() {
        return annonceService.listValide();
    }

    @GetMapping("/min")
    public Retour min() {
        return annonceService.getMin();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/refuser")
    public Retour listrefuse() {
        return annonceService.listRefuse();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/vendre")
    public Retour listvendu() {
        return annonceService.listVendu();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/non_valide")
    public Retour listNonValide() {
        return annonceService.listNonValide();
    }

    @GetMapping("/search/{motcle}")
    public Retour seacrh(@PathVariable String motcle) {
        return annonceService.listMotCle(motcle);
    }

    @GetMapping("/search")
    public Retour seacrh(@RequestBody SearchAnnonceDto searchAnnonceDto) {
        //System.out.println(searchAnnonceDto.getKilometrage());
        return annonceService.listMotCle(searchAnnonceDto);
        
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users")
    public Retour findByIdUsers() {
        return annonceService.getDetailsAnnonceIdusers();
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users/vendu")
    public Retour findVenduUsers() {
        return annonceService.getVenduUsers();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users/historique")
    public Retour findhistorique() {
        return annonceService.historique();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public String test() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test1")
    public String test1() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        
    }

    // @PostMapping("/uploadMultiple")
    // public String handleFileUploadMultiple(
    // @RequestParam("files") MultipartFile[] files) throws IOException {
    //     System.out.println("ok 1");
    //     //handle uploaded files
    //     if(files.length == 0) {
    //         return "aucun file";
    //     }
    //     else {
    //         System.out.println("ok 2");
    //         FileToBase64StringConversionUnitTest u = new FileToBase64StringConversionUnitTest();
    //         u.fileToBase64StringConversion();
    //     }
  
    //     return "Files uploaded successfully!";
    // }
    
    




}
