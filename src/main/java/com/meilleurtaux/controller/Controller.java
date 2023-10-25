package com.meilleurtaux.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class Controller {
    final String URL_GOUV = "https://geo.api.gouv.fr/communes";

    @GetMapping("/redirectWithRedirectView")
    @ExceptionHandler
    public RedirectView redirectWithUsingRedirectView(
            @RequestParam Integer codePostal) {
        String msg = "";
        if (codePostal != null)
            msg = "?codePostal=" + codePostal + "&fields=nom,population";
        return new RedirectView(URL_GOUV + msg);
    }
}
