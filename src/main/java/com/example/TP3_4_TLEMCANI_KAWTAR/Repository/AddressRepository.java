package com.example.TP3_4_TLEMCANI_KAWTAR.Repository;

import com.example.TP3_4_TLEMCANI_KAWTAR.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}