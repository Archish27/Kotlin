# Kotlin
Kotlin is a new programming language from JetBrains, the maker of the world’s best IDEs. After much searching, I have settled on it as the programming language I will probably use for the next 5–10 years or so.

I like Kotlin a lot and think it will be a very successful project. Someone who saw me using it in my open source work asked me to write about it, so in this article I’ll explain why I think Kotlin is good. Then I will discuss some of the problems and hiccups you may encounter if you start using it today. Finally, I’ll argue that now Kotlin is on the scene you should consider using the JVM if you aren’t already (e.g. because you use Go or Node).

## Why Kotlin is good
___
At first this article may seem strange: normally language advocacy articles start by listing all the cool features the new language has. This article does not; we will get to them later.
I am going to start by telling you about other things, because a 2013 study showed that language features matter little compared to ecosystem issues when developers evaluate programming languages. That tallies with my own experience, so, here we go:

**Kotlin compiles to JVM bytecode or JavaScript.** It is not a language you will write a kernel in. It is of greatest interest to people who work with Java today, although it could appeal to all programmers who use a garbage collected runtime, including people who currently use Scala, Go, Python, Ruby and JavaScript.

**Kotlin comes from industry**, not academia. It solves problems faced by working programmers today. As an example, the type system helps you avoid null pointer exceptions. Research languages tend to just not have null at all, but this is of no use to people working with large codebases and APIs which do.

**Kotlin costs nothing to adopt!** It’s open source, but that’s not what I mean here. What I mean is there’s a high quality, one-click Java to Kotlin converter tool, and a strong focus on Java binary compatibility. You can convert an existing Java project one file at a time and everything will still compile, even for complex programs that run to millions of lines of code. This is how I am adopting Kotlin and I expect it to be how most developers do.

As an obvious implication of the above, **Kotlin programs can use all existing Java frameworks and libraries**, even advanced frameworks that rely on annotation processing. The interop is seamless and does not require wrappers or adapter layers. It integrates with Maven, Gradle and other build systems.

It is approachable and **it can be learned in a few hours by simply reading the language reference.** The syntax is lean and intuitive. Kotlin looks a lot like Scala, but is simpler. The language balances terseness and readability well.

**It enforces no particular philosophy of programming**, such as overly functional or OOP styling.

It imposes **no runtime overhead.** The standard library is small and tight: it consists mostly of focused extensions to the Java standard library. Heavy use of compile-time inlining means functional constructs like pipelines of map/filter/reduce compile similarly to an imperative version of the same code.
Combined with the appearance of frameworks like Anko and Kovenant, this resource lightness means **Kotlin is starting to become popular with Android developers.** If you’re working on Android, you will soon be in good company. You can read a report written by a developer at Square on their experience with Kotlin and Android.

Kotlin allows you to keep using your productivity enhancing tools. If you use IntelliJ, **IDE interop is entirely seamless**: code can be refactored, searched, navigated and auto completed as if the Kotlin code was Java and vice-versa. There is full support for debugging, unit testing, profiling and so on.

Beyond Android, I think **Kotlin is highly suitable for enterprise Java shops.** If you spend all day working on big Java codebases at even bigger companies, you should investigate Kotlin because:

- It has **strong commercial support from an established company.** JetBrains is committed to the project, has a large and highly competent team working on it, has a stable business model and is even converting parts of their own flagship product to use it. Kotlin is unlikely to be abandoned any time soon.

- **Adopting Kotlin is low risk**: it can be trialled in a small part of your code base by one or two enthusiastic team members without disrupting the rest of your project: Kotlin classes export a Java API that looks identical to that of regular Java code.

- Because Kotlin focuses on readable syntax, **code reviews are not a problem**: they can still be done by team members who aren’t familiar with the language.

- **It targets Java 6**, so you can use it even if your deployment makes upgrading to a newer JVM difficult.

Earlier this year I presented Kotlin to a team of Java and .NET architects at Swiss Re, a large reinsurance company. I started by defining a simple Java class with a few fields, toString, equals, hashCode etc. It was about 50 lines of code. By the time we had finished converting it to Kotlin (mostly automatically), it had shrunk to just one line of code. I then demoed other time saving features. They were enthusiastic and saw it as a potentially strong competitor to C# for their own projects.

I think Kotlin hits the sweet spot for enterprise Java devs, so even though Kotlin is free I expect JetBrains to make a killing from increased sales of the commercial version of their IDE. This will incentivise them to keep improving it according to the wishes of their customers.

Contrast this with many other language developers who are subsidised by unrelated products, meaning they have little reason to respond to the demands of their users when those demands conflict with pre-held ideologies.

## Features
---
Kotlin stands out in a sea of new programming languages because of its focus on the ecosystem: JetBrains understand that productivity comes from more than convenient syntax.

Despite that, Kotlin has many useful features that make writing code in it pleasant:

- We already mentioned ***null safety (optionality)***, that lets the compiler systematically flag potential null pointer dereferences. Unlike some languages, this does not involve an option type and is therefore zero-overhead. Other language features ensure it’s not inconvenient.

- **Lean syntax:** type inference works everywhere, one liner functions take one line, simple structs/JavaBeans can also be declared in one line. **Real properties** generate getFoo/setFoo methods behind the scenes for Java interop. Functions can exist outside of classes.

- **Exceptions are unchecked.**

- Adding the data annotation to a class triggers **autogeneration of boilerplate** like equals, hashCode, toString, a copy method and variable spreading support (destructuring). This gives you convenient immutable classes without the need for builders.

- But if you do need to construct complex structures, a clever intersection of language features makes **builders clean and type safe (read: auto-completable).** If you use Google Protocol Buffers to store structured data, that gets easier too.

- **Functional programming support** with zero-overhead lambdas and ability to do mapping, folding etc over standard Java collections. The Kotlin type system distinguishes between mutable and immutable views over collections.

- **Extension functions** let you add methods to classes without modifying their source code. This looks at first like a superficial bit of syntax sugar to avoid FooUtils style classes. Then you realise that doing it this way enables you to easily discover the new methods via auto-completion, lets you build powerful language extensions and lets you integrate existing Java APIs with other Kotlin features. Features like …

- **Operator overloading**. But the good kind: no Scala / Perl style line noise here. Operators map to special method names, so can override the behaviour of the existing operators (including function invocation), but you cannot define entirely new ones. This strikes a balance between power and readability.

- Kotlin does not have macros or other ways to redefine the language, but a collection of carefully designed features allow for libraries that act like language extensions far more than they act like collections of objects. A good example: would you like to use **fibers, actors, and Go-style channels?** A library called Quasar has you covered.
- **Markdown instead of HTML** for your API docs. This makes writing JavaDocs much more pleasant. The “Dokka” tool, which is the equivalent of JavaDoc, can read both Kotlin and Java source code and generate combined doc websites, both with its own style and also in the standard JavaDoc HTML style.

- Better **generics**. If you never fully got to grips with what exactly super and extends mean when put inside a type variable, don’t worry: it’s not you. Java’s generics really are just confusing. Kotlin fixes it.

- **Delegation** (forwarding methods) can be done automatically.

- The **== operator** does what you actually expect.

- Would you like fast and convenient async programming? Of course you would.

- **String interpolation** "works like ${this.example}!"

- Function arguments can be named, optional and variadic.

- Many, many other tweaks and improvements. If something annoyed you about Java, I give it 50/50 that it’s fixed in Kotlin.
