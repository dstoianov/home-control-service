package se.techinsight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import se.techinsight.dto.CategoryDto;
import se.techinsight.model.Category;
import se.techinsight.repository.CategoryRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
//    private List<CategoryDto> categories = new ArrayList<>();

//    @PostConstruct
//    public void initData() {
//        categories.add(new CategoryDto(1, "Lidl"));
//        categories.add(new CategoryDto(2, "REWE"));
//    }

    public CategoryDto get(int id) {
        Category category = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + id));

        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    public List<CategoryDto> getAll() {
        return repository.findAll()
            .stream()
            .map(category -> {
                CategoryDto categoryDto = new CategoryDto();
                BeanUtils.copyProperties(category, categoryDto);
                return categoryDto;
            })
            .collect(toList());
    }

    public void delete(Integer id) {
        log.info("Remove category with id '{}'..", id);
        repository.findById(id)
            .ifPresent(entity -> repository.deleteById(id));
        // do not throw an exception to the user even if it is not exist
    }

    public void save(CategoryDto categoryDto) {

        Category category = new Category();

        BeanUtils.copyProperties(categoryDto, category);
        repository.save(category);

//        if (category.getId() == null) {
//            IntSummaryStatistics collect = categories.stream()
//                .collect(summarizingInt(CategoryDto::getId));
//            category.setId(collect.getMax() + 1);
//
//            categories.add(category);
//            return;
//        }
//
//        categories.stream()
//            .filter(cat -> cat.getId() == category.getId())
//            .findFirst()
//            .ifPresent(c -> c.setName(category.getName()));
    }
}
