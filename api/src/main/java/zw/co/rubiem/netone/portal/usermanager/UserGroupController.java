package zw.co.rubiem.netone.portal.usermanager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.ResponseMessage;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroup;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupRequest;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupService;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupUpdateRequest;

import java.util.Collection;


@CrossOrigin
@RestController
@Api(tags = "UserGroup")
@RequestMapping("v1/usergroups")
public class UserGroupController {

    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("")
    @ApiOperation("Get UserGroup")
    public ResponseEntity<?> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                    @RequestParam(required = false) String search) {
        try {
            Page<UserGroup> userGroups = userGroupService.findAll(pageable, search);
            return new ResponseEntity<Page<UserGroup>>(userGroups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    @ApiOperation("Get All UserGroup")
    public ResponseEntity<?> getAll() {
        try {
            Collection<UserGroup> userGroups = userGroupService.findAll();
            return new ResponseEntity<Collection<UserGroup>>(userGroups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a UserGroup by Id")
    public ResponseEntity<?> getUserGroup(@PathVariable long id) {
        try {
            UserGroup userGroups = userGroupService.findById(id);
            return new ResponseEntity<UserGroup>(userGroups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a UserGroup by Id")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            userGroupService.delete(id);
            return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("")
    @ApiOperation("Create UserGroup")
    public ResponseEntity<?> create(@RequestBody UserGroupRequest request) {
        try {
            UserGroup userGroupsCreated = userGroupService.create(request);
            return new ResponseEntity<UserGroup>(userGroupsCreated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Update UserGroup")
    public ResponseEntity<?> update(@RequestBody UserGroupUpdateRequest request, @PathVariable long id) {
        try {
            if (request.getId() != id) {
                throw new InvalidRequestException("Record not found!");
            }
            UserGroup userGroupsUpdated = userGroupService.update(request);
            return new ResponseEntity<UserGroup>(userGroupsUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
