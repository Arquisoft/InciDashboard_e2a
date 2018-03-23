package asw.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import asw.entities.Operator;
import asw.repository.OperatorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OperatorRepository operatorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Operator operario = operatorRepository.findByUser(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_OPERARIO"));

		User u = new User(operario.getName(), operario.getPassword(), grantedAuthorities);
		return u;

	}
	
	public Operator obtainOperatorForIncidence() {
		List<Operator> list = operatorRepository.findAll();
		Collections.sort(list, new Comparator<Operator>() {
		    @Override
		    public int compare(Operator o1, Operator o2) {
		        return o1.getNumeroIncidencias() - o2.getNumeroIncidencias();
		    }
		});
		return list.get(0);
	}
}
