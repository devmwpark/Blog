package com.blog.OwnerTest;

import com.blog.models.Category;
import com.blog.models.Owner;
import com.blog.models.enumerate.AccessLevel;
import com.blog.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author devmwpark[devmwpark@gmail.com]
 */

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "dev")
@Slf4j
@SpringBootTest
@Transactional
public class OwnerTest {

    @Autowired
    private OwnerRepository repository;

    @Test
    public void createTest(){

        Owner owner = new Owner();
        owner.setName("박민우");
        owner.setEmail("devmwpark@gmail.com");
        owner.setPassword("admin1234!");

        repository.save(owner);

        Optional<Owner> findResult = repository.findByEmail("devmwpark@gmail.com");

        assertNotNull("Owner 가 정상 생성되었습니다.",findResult.isPresent());
        assertThat("ID 는 0보다 큰 숫자가 자동으로 생성 되어야 합니다.",findResult.map(Owner::getId).orElse(0L), is(greaterThan(0L)));
        assertNotEquals("createTime 값은 자동생성 되어야 합니다.", Optional.empty(), findResult.map(Owner::getCreateTime));
        assertThat("Owner 최초생성시 디폴트 값은 Unknown 이어야 합니다.",findResult.map(Owner::getAccessLevel).equals(AccessLevel.UNKNOWN),is(notNullValue()));
    }
}
