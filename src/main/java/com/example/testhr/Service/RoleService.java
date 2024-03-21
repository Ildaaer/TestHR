package com.example.testhr.Service;

import com.example.testhr.Entyties.Role;
import com.example.testhr.Repository.RoleRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role not found: " + name));
    }



}
