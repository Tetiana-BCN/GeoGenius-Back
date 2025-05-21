package com.geogeniusback.geogeniusback.controller;

@RestController
@RequestMapping("/api/geoApi")
@CrossOrigin(origins = "*") // Allow requests from frontend
public class GeoController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/question")
    public ResponseEntity<QuizQuestion> getQuestion(@RequestBody QuizRequest request) {
        QuizQuestion question = quizService.generateQuestion(request.getMode(), request.getCountries());
        return ResponseEntity.ok(question);
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getAllCountries() {
        return ResponseEntity.ok(quizService.getAllCountries());
    }
}
