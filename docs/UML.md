
classDiagram
    class StudentAccount {
        -String id
        -String fullName
        -String email
        -String phone
        -String level
        -String major
        -boolean scholarship
        -List courses
        +getId()
        +getFullName()
        +getEmail()
        +clone()
    }

    class Builder {
        +Builder(id, fullName, email)
        +phone(phone)
        +level(level)
        +major(major)
        +scholarship(value)
        +courses(list)
        +build()
    }

    class AccountRepository {
        -AccountRepository instance
        +getInstance()
        +addAccount()
        +findById()
        +getAllAccounts()
    }

    class AuditLogger {
        -AuditLogger instance
        +getInstance()
        +log(message)
    }

    class StudentAccountPrototype {
        -StudentAccount template
        +createStudent()
    }

    class UniversityComponent {
        <<interface>>
        +getName()
        +getStudentCount()
        +display()
    }

    class UniversityUnit {
        -String name
        +add()
        +remove()
        +getStudentCount()
        +display()
    }

    class StudentNode

    class AccountState {
        <<interface>>
        +activate()
        +suspend()
        +close()
        +login()
        +getStatus()
    }

    class AccountLifecycle
    class PendingState
    class ActiveState
    class SuspendedState
    class ClosedState

    class AccountObserver {
        <<interface>>
        +onEvent()
    }

    class AccountEventManager {
        +addObserver()
        +notifyObservers()
    }

    class AuditObserver
    class EmailNotifier
    class AdminDashboard

    class ExportStrategy {
        <<interface>>
        +export()
    }

    class CsvExport
    class JsonExport

    class LegacyStudentSystem {
        +fetchRecords()
    }

    class LegacyStudentAdapter {
        +importStudents()
    }

    class StudentServices {
        <<interface>>
        +getDescription()
    }

    class BasicStudentServices
    class StudentServiceDecorator
    class LibraryDecorator
    class CafeteriaDecorator
    class InternetDecorator

    class UniAccountsFacade {
        +createAccount()
        +activateAccount()
        +suspendAccount()
        +closeAccount()
        +login()
        +exportAccounts()
        +importLegacyStudents()
    }

    StudentAccount *-- Builder
    AccountRepository --> StudentAccount
    StudentAccountPrototype --> StudentAccount

    UniversityComponent <|.. UniversityUnit
    UniversityComponent <|.. StudentNode
    UniversityUnit o-- UniversityComponent

    AccountState <|.. PendingState
    AccountState <|.. ActiveState
    AccountState <|.. SuspendedState
    AccountState <|.. ClosedState
    AccountLifecycle --> AccountState

    AccountObserver <|.. AuditObserver
    AccountObserver <|.. EmailNotifier
    AccountObserver <|.. AdminDashboard
    AccountEventManager o-- AccountObserver

    ExportStrategy <|.. CsvExport
    ExportStrategy <|.. JsonExport

    LegacyStudentAdapter --> LegacyStudentSystem
    LegacyStudentAdapter --> AccountRepository

    StudentServices <|.. BasicStudentServices
    StudentServices <|.. StudentServiceDecorator
    StudentServiceDecorator <|-- LibraryDecorator
    StudentServiceDecorator <|-- CafeteriaDecorator
    StudentServiceDecorator <|-- InternetDecorator

    UniAccountsFacade --> AccountRepository
    UniAccountsFacade --> AccountEventManager
    UniAccountsFacade --> AccountLifecycle
    UniAccountsFacade --> ExportStrategy
