/* eslint-disable sort-keys */
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import '@testing-library/jest-dom/extend-expect';
import {fireEvent, render, waitFor, within} from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import React from 'react';

import Detail from '../../../src/main/resources/META-INF/resources/js/components/detail/Detail';
import {ChartStateContextProvider} from '../../../src/main/resources/META-INF/resources/js/context/ChartStateContext';
import {StoreContextProvider} from '../../../src/main/resources/META-INF/resources/js/context/StoreContext';

const mockCurrentPageOrganic = {
	data: {
		countryKeywords: [
			{
				countryCode: 'us',
				countryName: 'United States',
				keywords: [
					{
						keyword: 'commerce',
						position: 1,
						searchVolume: 12300,
						traffic: 90000,
					},
					{
						keyword: 'e-commerce',
						position: 2,
						searchVolume: 9800,
						traffic: 14800,
					},
					{
						keyword: 'what is commerce',
						position: 3,
						searchVolume: 9500,
						traffic: 14000,
					},
					{
						keyword: 'what is e-commerce',
						position: 4,
						searchVolume: 8700,
						traffic: 12100,
					},
					{
						keyword:
							'commerce definition for new business strategy',
						position: 5,
						searchVolume: 7100,
						traffic: 10100,
					},
				],
			},
			{
				countryCode: 'es',
				countryName: 'Spain',
				keywords: [
					{
						keyword: 'commerce',
						position: 1,
						searchVolume: 12300,
						traffic: 90000,
					},
					{
						keyword: 'e-commerce',
						position: 2,
						searchVolume: 9800,
						traffic: 14800,
					},
					{
						keyword: 'what is commerce',
						position: 3,
						searchVolume: 9500,
						traffic: 14000,
					},
					{
						keyword: 'what is e-commerce',
						position: 4,
						searchVolume: 8700,
						traffic: 12100,
					},
					{
						keyword:
							'commerce definition for new business strategy',
						position: 5,
						searchVolume: 7100,
						traffic: 10100,
					},
				],
			},
		],
		helpMessage:
			'This number refers to the volume of people that find your page through a search engine.',
		name: 'organic',
		share: 90,
		title: 'Organic',
		value: 278256,
	},
	view: 'organic',
};

const mockCurrentPageReferral = {
	data: {
		helpMessage:
			'This is the number of page views generated by people coming to your page from other sites which are not search engine pages or social sites.',
		name: 'referral',
		referringDomains: [
			{
				trafficAmount: 17985230,
				url: 'http://foo.example.com',
			},
			{
				trafficAmount: 12218030,
				url: 'http://bar.example.com',
			},
			{
				trafficAmount: 9062949,
				url: 'http://baz.example.com',
			},
			{
				trafficAmount: 4601453,
				url: 'http://qux.example.com',
			},
			{
				trafficAmount: 253399,
				url: 'http://fred.example.com',
			},
		],
		referringPages: [
			{
				trafficAmount: 125461,
				url: 'http://one.example.com',
			},
			{
				trafficAmount: 85485,
				url: 'http://two.example.com',
			},
			{
				trafficAmount: 84564,
				url: 'http://three.example.com',
			},
			{
				trafficAmount: 5846,
				url: 'http://four.example.com',
			},
			{
				trafficAmount: 3521,
				url: 'http://five.example.com',
			},
			{
				trafficAmount: 2513,
				url: 'http://six.example.com',
			},
			{
				trafficAmount: 2200,
				url: 'http://seven.example.com',
			},
			{
				trafficAmount: 1230,
				url: 'http://eight.example.com',
			},
			{
				trafficAmount: 1100,
				url: 'http://nine.example.com',
			},
			{
				trafficAmount: 100,
				url: 'http://ten.example.com',
			},
		],
		share: 90,
		title: 'Referral',
		value: 278256,
	},
	view: 'referral',
};

const mockCurrentPageSocial = {
	data: {
		helpMessage:
			'This is the number of page views generated by people coming to your page from social sites.',
		name: 'social',
		referringSocialMedia: [
			{
				name: 'facebook',
				title: 'Facebook',
				trafficAmount: 1729,
			},
			{
				name: 'linkedin',
				title: 'LinkedIn',
				trafficAmount: 1256,
			},
			{
				name: 'pinterest',
				title: 'Pinterest',
				trafficAmount: 771,
			},
			{
				name: 'others',
				title: 'Others',
				trafficAmount: 30,
			},
		],
		share: 90,
		title: 'Social',
		value: 278256,
	},
	view: 'social',
};

const mockLanguageTag = 'en-US';

const mockTimeSpanOptions = [
	{
		key: 'last-30-days',
		label: 'Last 30 Days',
	},
	{
		key: 'last-7-days',
		label: 'Last 7 Days',
	},
	{
		key: 'last-24-hours',
		label: 'Last 24 Hours',
	},
];

const mockTrafficSourcesData = [
	{
		name: 'direct',
		share: '100.0',
		title: 'Direct',
		value: 16,
		helpMessage:
			'This is the number of page views generated by people arriving directly to your page.',
	},
	{
		referringPages: [
			{
				trafficAmount: 80,
				url: 'http://clara.com',
			},
			{
				trafficAmount: 15,
				url: 'http://clara2.com',
			},
			{
				trafficAmount: 5,
				url: 'http://clara3.com',
			},
		],
		referringDomains: [
			{
				trafficAmount: 93,
				url: 'http://beltran2.com',
			},
			{
				trafficAmount: 64,
				url: 'http://beltran3.com',
			},
			{
				trafficAmount: 24,
				url: 'http://beltran1.com',
			},
		],
		name: 'referral',
		share: '40.0',
		title: 'Referral',
		value: 100,
		helpMessage:
			'This is the number of page views generated by people coming to your page from other sites which are not search engine pages or social sites.',
	},
	{
		name: 'social',
		share: '40.0',
		title: 'Social',
		referringSocialMedia: [
			{
				name: 'twitter',
				trafficAmount: 29,
				title: 'Twitter',
			},
			{
				name: 'facebook',
				trafficAmount: 25,
				title: 'Facebook',
			},
			{
				name: 'instagram',
				trafficAmount: 11,
				title: 'Instagram',
			},
		],
		value: 100,
		helpMessage:
			'This is the number of page views generated by people coming to your page from social sites.',
	},
	{
		countryKeywords: [
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'españa',
						traffic: 200,
					},
				],
				countryCode: 'es',
				countryName: 'Spain',
			},
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'englang',
						traffic: 200,
					},
				],
				countryCode: 'en',
				countryName: 'EN',
			},
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'french',
						traffic: 200,
					},
				],
				countryCode: 'fr',
				countryName: 'France',
			},
		],
		name: 'paid',
		share: '40.0',
		title: 'Paid',
		value: 100,
		helpMessage:
			'This is the number of page views generated by people that find your page through Google AdWords.',
	},
	{
		countryKeywords: [
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'españa',
						traffic: 200,
					},
				],
				countryCode: 'es',
				countryName: 'Spain',
			},
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'englang',
						traffic: 200,
					},
				],
				countryCode: 'en',
				countryName: 'EN',
			},
			{
				keywords: [
					{
						searchVolume: 100,
						position: 0,
						keyword: 'french',
						traffic: 200,
					},
				],
				countryCode: 'fr',
				countryName: 'France',
			},
		],
		name: 'organic',
		share: '40.0',
		title: 'Organic',
		value: 100,
		helpMessage:
			'This is the number of page views generated by people coming from a search engine.',
	},
];

const mockOnCurrentPageChange = jest.fn(() => Promise.resolve({view: 'main'}));

const mockOnTrafficSourceNameChange = jest.fn(() => Promise.resolve(''));

const mockTrafficShareDataProvider = jest.fn(() => Promise.resolve(90));

const mockTrafficVolumeDataProvider = jest.fn(() => Promise.resolve(278256));

const mockTrafficSourcesDataProvider = jest.fn(() =>
	Promise.resolve(mockTrafficSourcesData)
);

describe('Detail', () => {
	afterEach(() => {
		jest.clearAllMocks();
	});

	it('displays 10 urls when clicking on the view more button', async () => {
		const testProps = {
			pagePublishDate: 'Thu Aug 10 08:17:57 GMT 2019',
			timeRange: {endDate: '2020-02-02', startDate: '2020-01-27'},
			timeSpanKey: 'last-7-days',
		};

		const {getByText} = render(
			<StoreContextProvider value={{languageTag: mockLanguageTag}}>
				<ChartStateContextProvider
					publishDate={testProps.publishDate}
					timeRange={testProps.timeRange}
					timeSpanKey={testProps.timeSpanKey}
				>
					<Detail
						currentPage={mockCurrentPageReferral}
						onCurrentPageChange={mockOnCurrentPageChange}
						onTrafficSourceNameChange={
							mockOnTrafficSourceNameChange
						}
						timeSpanOptions={mockTimeSpanOptions}
						trafficShareDataProvider={mockTrafficShareDataProvider}
						trafficSourcesDataProvider={
							mockTrafficSourcesDataProvider
						}
						trafficVolumeDataProvider={
							mockTrafficVolumeDataProvider
						}
					/>
				</ChartStateContextProvider>
			</StoreContextProvider>
		);

		await waitFor(() => {
			expect(mockTrafficShareDataProvider).toHaveBeenCalled();
			expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
		});

		const viewMoreButton = getByText('view-more');
		userEvent.click(viewMoreButton);

		expect(getByText('http://six.example.com')).toBeInTheDocument();
		expect(getByText('http://seven.example.com')).toBeInTheDocument();
		expect(getByText('http://eight.example.com')).toBeInTheDocument();
		expect(getByText('http://nine.example.com')).toBeInTheDocument();
		expect(getByText('http://ten.example.com')).toBeInTheDocument();

		expect(getByText('view-less')).toBeInTheDocument();
	});

	describe('Organic Detail', () => {
		it('displays the organic detail according to API', async () => {
			const {getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			expect(getByText('Organic')).toBeInTheDocument();
			expect(getByText('90%')).toBeInTheDocument();
			expect(getByText('278,256')).toBeInTheDocument();

			expect(mockTrafficShareDataProvider).toHaveBeenCalledTimes(1);
			expect(mockTrafficVolumeDataProvider).toHaveBeenCalledTimes(1);
		});

		it('displays the top five relevant keywords by country sorted by traffic', async () => {
			const {getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			expect(getByText('United States')).toBeInTheDocument();
			expect(getByText('Spain')).toBeInTheDocument();

			expect(getByText('commerce')).toBeInTheDocument();
			expect(getByText('90,000')).toBeInTheDocument();

			expect(getByText('e-commerce')).toBeInTheDocument();
			expect(getByText('14,800')).toBeInTheDocument();

			expect(getByText('what is commerce')).toBeInTheDocument();
			expect(getByText('14,000')).toBeInTheDocument();

			expect(getByText('what is e-commerce')).toBeInTheDocument();
			expect(getByText('12,100')).toBeInTheDocument();

			expect(
				getByText('commerce definition for new business strategy')
			).toBeInTheDocument();
			expect(getByText('10,100')).toBeInTheDocument();
		});

		it('displays a tooltip with info on hover tooltip signs', async () => {
			const {getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			const bestKeywordLabel = getByText('best-keyword');
			const questionCircleIcon = within(bestKeywordLabel).getByRole(
				'presentation'
			);
			fireEvent.mouseEnter(questionCircleIcon);
			expect(getByText('best-keyword-help')).toBeInTheDocument();
		});

		it('displays a dropdown with options to display in the keywords table', async () => {
			const {getAllByText, getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			const trafficDropdown = getAllByText('traffic')[0];
			userEvent.click(trafficDropdown);
			expect(getByText('search-volume')).toBeInTheDocument();
			expect(getByText('position')).toBeInTheDocument();
		});

		it('displays the top five relevant keywords sorted by search volume when user clicks on the dropdown option search volume', async () => {
			const {getAllByText, getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			const trafficDropdown = getAllByText('traffic')[0];
			userEvent.click(trafficDropdown);
			const searchVolumeLabel = getByText('search-volume');
			userEvent.click(searchVolumeLabel);

			expect(getByText('commerce')).toBeInTheDocument();
			expect(getByText('12,300')).toBeInTheDocument();

			expect(getByText('e-commerce')).toBeInTheDocument();
			expect(getByText('9,800')).toBeInTheDocument();

			expect(getByText('what is commerce')).toBeInTheDocument();
			expect(getByText('9,500')).toBeInTheDocument();

			expect(getByText('what is e-commerce')).toBeInTheDocument();
			expect(getByText('8,700')).toBeInTheDocument();

			expect(
				getByText('commerce definition for new business strategy')
			).toBeInTheDocument();
			expect(getByText('7,100')).toBeInTheDocument();
		});

		it('displays the top five relevant keywords sorted by position when user clicks on the dropdown option position', async () => {
			const {getAllByText, getByText} = render(
				<Detail
					currentPage={mockCurrentPageOrganic}
					onCurrentPageChange={mockOnCurrentPageChange}
					onTrafficSourceNameChange={mockOnTrafficSourceNameChange}
					timeSpanOptions={mockTimeSpanOptions}
					trafficShareDataProvider={mockTrafficShareDataProvider}
					trafficVolumeDataProvider={mockTrafficVolumeDataProvider}
				/>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			const trafficDropdown = getAllByText('traffic')[0];
			userEvent.click(trafficDropdown);
			const searchVolumeLabel = getByText('position');
			userEvent.click(searchVolumeLabel);

			expect(getByText('commerce')).toBeInTheDocument();
			expect(getByText('1')).toBeInTheDocument();

			expect(getByText('e-commerce')).toBeInTheDocument();
			expect(getByText('2')).toBeInTheDocument();

			expect(getByText('what is commerce')).toBeInTheDocument();
			expect(getByText('3')).toBeInTheDocument();

			expect(getByText('what is e-commerce')).toBeInTheDocument();
			expect(getByText('4')).toBeInTheDocument();

			expect(
				getByText('commerce definition for new business strategy')
			).toBeInTheDocument();
			expect(getByText('5')).toBeInTheDocument();
		});
	});

	describe('Referral Detail', () => {
		it('displays the referral detail according to API', async () => {
			const testProps = {
				pagePublishDate: 'Thu Aug 10 08:17:57 GMT 2019',
				timeRange: {endDate: '2020-02-02', startDate: '2020-01-27'},
				timeSpanKey: 'last-7-days',
			};

			const {getByText} = render(
				<StoreContextProvider value={{languageTag: mockLanguageTag}}>
					<ChartStateContextProvider
						publishDate={testProps.publishDate}
						timeRange={testProps.timeRange}
						timeSpanKey={testProps.timeSpanKey}
					>
						<Detail
							currentPage={mockCurrentPageReferral}
							onCurrentPageChange={mockOnCurrentPageChange}
							onTrafficSourceNameChange={
								mockOnTrafficSourceNameChange
							}
							timeSpanOptions={mockTimeSpanOptions}
							trafficShareDataProvider={
								mockTrafficShareDataProvider
							}
							trafficVolumeDataProvider={
								mockTrafficVolumeDataProvider
							}
						/>
					</ChartStateContextProvider>
				</StoreContextProvider>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			expect(getByText('Referral')).toBeInTheDocument();
			expect(getByText('90%')).toBeInTheDocument();
			expect(getByText('278,256')).toBeInTheDocument();

			expect(getByText('top-referring-pages')).toBeInTheDocument();
			expect(getByText('http://one.example.com')).toBeInTheDocument();
			expect(getByText('125,461')).toBeInTheDocument();
			expect(getByText('http://two.example.com')).toBeInTheDocument();
			expect(getByText('85,485')).toBeInTheDocument();
			expect(getByText('http://three.example.com')).toBeInTheDocument();
			expect(getByText('84,564')).toBeInTheDocument();
			expect(getByText('http://four.example.com')).toBeInTheDocument();
			expect(getByText('5,846')).toBeInTheDocument();
			expect(getByText('http://five.example.com')).toBeInTheDocument();
			expect(getByText('3,521')).toBeInTheDocument();

			expect(getByText('view-more')).toBeInTheDocument();

			expect(getByText('top-referring-domains')).toBeInTheDocument();
			expect(getByText('http://foo.example.com')).toBeInTheDocument();
			expect(getByText('17,985,230')).toBeInTheDocument();
			expect(getByText('http://bar.example.com')).toBeInTheDocument();
			expect(getByText('12,218,030')).toBeInTheDocument();
			expect(getByText('http://baz.example.com')).toBeInTheDocument();
			expect(getByText('9,062,949')).toBeInTheDocument();
			expect(getByText('http://qux.example.com')).toBeInTheDocument();
			expect(getByText('4,601,453')).toBeInTheDocument();
			expect(getByText('http://fred.example.com')).toBeInTheDocument();
			expect(getByText('253,399')).toBeInTheDocument();

			expect(mockTrafficShareDataProvider).toHaveBeenCalledTimes(1);
			expect(mockTrafficVolumeDataProvider).toHaveBeenCalledTimes(1);

			expect(getByText('Last 7 Days')).toBeInTheDocument();
			expect(getByText('Jan 27 - Feb 2, 2020')).toBeInTheDocument();
		});
	});

	describe('Social Detail', () => {
		it('displays the social detail according to API', async () => {
			const testProps = {
				pagePublishDate: 'Thu Aug 10 08:17:57 GMT 2019',
				timeRange: {endDate: '2020-02-02', startDate: '2020-01-27'},
				timeSpanKey: 'last-7-days',
			};

			const {getByText} = render(
				<StoreContextProvider value={{languageTag: mockLanguageTag}}>
					<ChartStateContextProvider
						publishDate={testProps.publishDate}
						timeRange={testProps.timeRange}
						timeSpanKey={testProps.timeSpanKey}
					>
						<Detail
							currentPage={mockCurrentPageSocial}
							onCurrentPageChange={mockOnCurrentPageChange}
							onTrafficSourceNameChange={
								mockOnTrafficSourceNameChange
							}
							timeSpanOptions={mockTimeSpanOptions}
							trafficShareDataProvider={
								mockTrafficShareDataProvider
							}
							trafficVolumeDataProvider={
								mockTrafficVolumeDataProvider
							}
						/>
					</ChartStateContextProvider>
				</StoreContextProvider>
			);

			await waitFor(() => {
				expect(mockTrafficShareDataProvider).toHaveBeenCalled();
				expect(mockTrafficVolumeDataProvider).toHaveBeenCalled();
			});

			expect(getByText('Social')).toBeInTheDocument();
			expect(getByText('90%')).toBeInTheDocument();
			expect(getByText('278,256')).toBeInTheDocument();

			expect(getByText('top-referring-social-media')).toBeInTheDocument();

			expect(getByText('Facebook')).toBeInTheDocument();
			expect(getByText('1,729')).toBeInTheDocument();
			expect(getByText('LinkedIn')).toBeInTheDocument();
			expect(getByText('1,256')).toBeInTheDocument();
			expect(getByText('Pinterest')).toBeInTheDocument();
			expect(getByText('771')).toBeInTheDocument();
			expect(getByText('Others')).toBeInTheDocument();
			expect(getByText('30')).toBeInTheDocument();

			expect(mockTrafficShareDataProvider).toHaveBeenCalledTimes(1);
			expect(mockTrafficVolumeDataProvider).toHaveBeenCalledTimes(1);

			expect(getByText('Last 7 Days')).toBeInTheDocument();
			expect(getByText('Jan 27 - Feb 2, 2020')).toBeInTheDocument();
		});
	});
});
