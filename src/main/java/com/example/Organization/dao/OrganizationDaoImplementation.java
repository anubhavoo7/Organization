package com.example.Organization.dao;

import com.example.Organization.entity.*;
import com.example.Organization.filter.Filter;
import com.example.Organization.model.Pageable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class OrganizationDaoImplementation implements OrganizationDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Employee saveEmp(Employee employee) {
        employee = entityManager.merge(employee);
        return employee;
    }

    @Override
    @Transactional
    public Boolean isExists(String movieTitleToCheck) {
        String queryString =
                "SELECT COUNT(m) FROM Employee m WHERE m.movieTitle = :movieTitle AND m.deleted=false";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("movieTitle", movieTitleToCheck);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    @Transactional
    @Override
    public Member saveMember(Member member) {
        member = entityManager.merge(member);
        return member;
    }



    @Transactional
    @Override
    public Team saveTeam(Team team) {
        team = entityManager.merge(team);
        return team;
    }

    @Override
    @Transactional
    public Pageable getEmpCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue()),
                            criteriaBuilder.equal(root.get("deleted"), 0)));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    @Transactional
    public Pageable getMemberCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Member> root = criteriaQuery.from(Member.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())), criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }


    @Override
    public Pageable getTeamCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Team> root = criteriaQuery.from(Team.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())),
                            criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }



    @Override
    @Transactional
    public List<Employee> getAllEmp(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Member> getAllMember(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
        Root<Member> root = criteriaQuery.from(Member.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Member> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }


    @Override
    public List<Team> getAllTeam(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);
        Root<Team> root = criteriaQuery.from(Team.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Team> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public static Integer calculatesPages(long pageSize, long count) {
        return count < pageSize ? 1 : (int) Math.ceil((double) count / pageSize);
    }

    @Transactional
    @Override
    public Employee getByEmpId(String id) {
        TypedQuery<Employee> typedQuery =
                entityManager
                        .createQuery("from Employee where empId=:id", Employee.class)
                        .setParameter("id", id);

        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Member getByMemberId(String id) {
        TypedQuery<Member> typedQuery =
                entityManager
                        .createQuery("from Member where memberId=:id", Member.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }


    @Transactional
    @Override
    public Team getByTeamId(String id) {
        TypedQuery<Team> typedQuery =
                entityManager
                        .createQuery("from Team where teamId=:id", Team.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }




    @Transactional
    @Override
    public int softdeleteEmp(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Employee set deleted = true where empId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

    @Transactional
    @Override
    public int softdeleteMember(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Member set deleted = true where memberId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }


    @Transactional
    @Override
    public int softdeleteTeam(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Team set deleted = true where teamId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

}
