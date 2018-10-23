package net.thjang.blog.dao;

import net.thjang.blog.dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class MemberDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public MemberDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert
                = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public Long addMember(Member member) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);

        return simpleJdbcInsert.executeAndReturnKey(params).longValue();
    }

    public Member getMember(String email) {
//        String sql = "SELECT id, name, email, password, regdate FROM member WHERE email = :email";
        String sql = "SELECT id, name, email, password FROM member WHERE email = :email";

        try {
            RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
            Map<String, ?> params = Collections.singletonMap("email", email);

            return jdbcTemplate.queryForObject(sql, params, rowMapper);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
