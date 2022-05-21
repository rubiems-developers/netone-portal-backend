package zw.co.rubiem.netone.portal.usermanager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.ResponseMessage;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.usermanager.useraccount.*;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupService;

import javax.validation.Valid;
import java.security.Principal;

import static java.util.Objects.isNull;


@Slf4j
@CrossOrigin
@RestController
@Api(tags = "UserAccount")
public class UserAccountController {

    private final UserAccountService userService;

    private final UserGroupService userGroupService;

    public UserAccountController(UserAccountService userService, UserGroupService userGroupService) {
        this.userService = userService;
        this.userGroupService = userGroupService;
    }

    @GetMapping("/v1/users")
    @ApiOperation("Get Users")
    public ResponseEntity<?> getAll(@PageableDefault(sort = "username") Pageable pageable, @RequestParam(required = false) String search) {
        log.info("getAll() request: {} ", pageable);
        try {
            val users = userService.findAll(pageable, search);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/v1/users/all")
    @ApiOperation("Get All Users")
    public ResponseEntity<?> getAll() {
        log.info("getUser() request: {} ");
        try {
            val users = userService.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/v1/user/{userId}")
    @ApiOperation("Get a User by Id")
    public ResponseEntity<?> getUser(@PathVariable long userId) {
        log.info("getUser() request: {} ", userId);
        try {
            val user = userService.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/v1/user/{userId}")
    @ApiOperation("Delete a User by Id")
    public ResponseEntity<?> delete(@PathVariable long userId) {
        log.info("delete() request: {} ", userId);
        try {
            userService.delete(userId);
            return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/v1/verify-user")
    @ApiOperation("Verify User Account")
    public void verifyUser(@RequestParam String token) {
        userService.verifyUser(token);
    }

    @GetMapping("/v1/users/my-profile")
    @ApiOperation("Get My User Profile")
    public ResponseEntity<?> myProfile(Principal principal) {
        log.info("myProfile() request: {} ", principal);
        try {
            val user = userService.findByUsername(principal.getName());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/v1/users")
    @ApiOperation(tags = "Create New Account", value = "Create User")
    @PreAuthorize("hasAnyAuthority('CREATE_USER', 'SUPER_ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody UserAccountRequest userAccountRequest, Principal principal) {
        log.info("create() request: {} ", userAccountRequest);
        try {
            val user = userService.create(userAccountRequest);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/v1/users/{userId}")
    @ApiOperation("Update User")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public ResponseEntity<?> update(@RequestBody UserAccountUpdateRequest userAccountUpdateRequest, @PathVariable long userId) {
        log.info("updateUser() request: {} ", userAccountUpdateRequest);
        try {
            if (userAccountUpdateRequest.getId() != userId) {
                throw new InvalidRequestException("Record not found!");
            }
            val user = userService.update(userAccountUpdateRequest);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/v1/forgot-password")
    @ApiOperation("Forgot Password Request")
    public ResponseEntity<?> forgotPassword(@RequestParam(required = false) String username) {
        log.info("forgotPassword() request: {} " + username);
        try {
            userService.forgotPassword(username);
            return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/v1/reset-password")
    @ApiOperation("Reset Password Request")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordContext resetPasswordContext) {
        log.info("resetPassword() request: {} ", resetPasswordContext);
        try {
            userService.resetPassword(resetPasswordContext);
            return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/v1/update-password")
    @ApiOperation("Update Password Request")
    public ResponseEntity<?> changePassword(@Valid @RequestBody UpdatePasswordContext updatePasswordContext, Principal principal) {

        log.info("changePassword() request: {} ", updatePasswordContext);
        try {
            if (isNull(principal)) {
                throw new InvalidRequestException("You need to be logged in to perform this action.");
            }
            updatePasswordContext.setUsername(principal.getName());
            val user = userService.updatePassword(updatePasswordContext);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/system/v1/users/by-username")
    @ApiOperation("Get system user Details")
    public ResponseEntity<?> findByUsername(@RequestParam String username) {
        log.info("findByUsername() request: {} ", username);
        try {
            val user = userService.findByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/system/v1/groups/{groupId}/users")
    @ApiOperation("Get system Group user Details")
    public ResponseEntity<?> findByGroup(@PathVariable long groupId) {
        log.info("findByGroup() request: {} ", groupId);
        try {
            val users = userService.findByGroup(groupId);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
