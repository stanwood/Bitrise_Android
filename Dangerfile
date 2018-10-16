# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn "Big PR" if git.lines_of_code > 500
# Check added files - for performance reasons bundle all added file checks in this loop!
git.added_files.each do |file|
    # Check whether Java files are in the java source directory
    if file =~ /\.(java)$/
        warn "#{file}: New Java class isn't in java source directory!" unless file =~ /\/(java)\//
    end
    # Check whether new classes are implemented in Kotlin
    warn "#{file}: Try to implement new classes in Kotlin if possible." if file =~ /\.java$/
end
# Check modified files - for performance reasons bundle all file checks in this loop!
modifiedWithoutDeleted = (git.modified_files - git.deleted_files)
modifiedWithoutDeleted.each do |file|
    linenumber = 0
    # Check lines in modified files - for performance reasons bundle all line checks in this loop!
    # Note, that we also check unmodified lines here!
    File.open(file).each_line do |li|
        linenumber += 1
        # Java/Kotlin checks
        if file =~ /\.(kt|java)$/
            # Check whether there is an usage of unsecured ExifInterface constructor in .kt or .java files
            fail "#{file}:#{linenumber}: usage of ExifInterface - please use SecureExifInterface instead!" if li[/android\.media\.ExifInterface( )*\(|[\s\t]ExifInterface( )*\(/]
            # Check whether there is an if NOT followed by a space
            warn "#{file}:#{linenumber}: No space following if - please also correct in unchanged code!" if li[/([\s|\t]if\()+/]
            # Check whether there are TODOs or FIXMEs
            warn "#{file}:#{linenumber}: Don't commit code which includes TODOs or FIXMEs! Fix them or they will stay forever! ;)" if
            li[/\/\/TODO|\/\/ TODO|@TODO|\/\/FIXME|\/\/ FIXME/]
            # Check whether there are DEBUG lines
            fail "#{file}:#{linenumber}: Don't commit code which includes DEBUG code!" if li[/\/\/DEBUG|\/\/ DEBUG|@DEBUG/]
        end
        if file =~ /\.(kt)$/
            warn "#{file}:#{linenumber}: Check whether you really need !! or if you can replace it by ? or similar." if li[/!!/]
        end
        # translation check
        if file =~ /strings\.xml$/
            warn "#{file}:#{linenumber}: Could it be that formatted='false' is missing." if li[/^(?:(?!formatted="false").)+(%\w*%)+/]
            warn "#{file}:#{linenumber}: Could it be that formatted='false' is not needed." if li[/(formatted="false")+(?:(?!(%.*%)).)+$/]
            warn "#{file}:#{linenumber}: Multiple spaces." if li[/<string.* {2,}.*string>/]
        end
    end
end
