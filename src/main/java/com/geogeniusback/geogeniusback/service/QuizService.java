package com.geogeniusback.geogeniusback.service;

@Service
public class QuizService {
    @Autowired
    private CountryRepository countryRepo;

    public QuizQuestion generateQuestion(String mode, List<String> countryNames) {
        List<Country> countries = countryRepo.findByNameIn(countryNames);

        if (countries.size() < 1) throw new IllegalArgumentException("No valid countries selected.");

        Country picked = countries.get(new Random().nextInt(countries.size()));

        String question;
        String correctAnswer;
        List<String> options = new ArrayList<>();

        if ("capital".equalsIgnoreCase(mode)) {
            question = "What is the capital of " + picked.getName() + "?";
            correctAnswer = picked.getCapital();
            options = countries.stream()
                .map(Country::getCapital)
                .distinct()
                .limit(4)
                .collect(Collectors.toList());
        } else {
            question = "Which country has the capital " + picked.getCapital() + "?";
            correctAnswer = picked.getName();
            options = countries.stream()
                .map(Country::getName)
                .distinct()
                .limit(4)
                .collect(Collectors.toList());
        }

        
        if (!options.contains(correctAnswer)) {
            options.set(new Random().nextInt(options.size()), correctAnswer);
        }
        Collections.shuffle(options);

        return new QuizQuestion(question, correctAnswer, options);
    }

    public List<String> getAllCountries() {
        return countryRepo.findAll()
                .stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }
}

