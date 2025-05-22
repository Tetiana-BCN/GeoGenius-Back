@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get a random set of countries from the database
    public List<String> getRandomCountries(List<String> countryIds) {
        Random random = new Random();
        List<Country> countries = countryRepository.findAllById(countryIds);
        
        // Shuffle the countries to pick 4 random ones
        Collections.shuffle(countries);
        
        return countries.stream()
                         .limit(4)
                         .map(Country::getName)
                         .collect(Collectors.toList());
    }

    public List<String> getQuizOptions(List<String> randomCountries) {
        // Return the options (4 countries including the correct answer)
        List<String> options = new ArrayList<>(randomCountries);
        // Add some other random countries to fill options
        return options;
    }
}
