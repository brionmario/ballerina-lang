module.exports = {
    'roots': [
        '<rootDir>/tests'
    ],
    'transform': {
        '.*\.tsx?$': 'ts-jest'
    },
    'testRegex': '(/__tests__/.*|(\\.|/)(test|spec))\\.(jsx?|tsx?)$',
    'moduleFileExtensions': [
        'ts',
        'tsx',
        'js',
        'jsx',
        'json',
        'node'
    ],
    "collectCoverageFrom": [
        "!**/build/**",
        "**/src/**",
        "!**/node_modules/**",
    ]
}